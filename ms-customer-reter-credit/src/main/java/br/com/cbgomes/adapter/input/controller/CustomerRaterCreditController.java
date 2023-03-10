package br.com.cbgomes.adapter.input.controller;

import br.com.cbgomes.adapter.input.api.CustomerRaterCreditApi;
import br.com.cbgomes.adapter.input.api.request.CustomerRaterCreditRequest;
import br.com.cbgomes.adapter.input.api.request.DataEvaluationCustomer;
import br.com.cbgomes.adapter.input.api.request.DataIssuanceCardRequest;
import br.com.cbgomes.adapter.input.api.response.CardApprovedResponse;
import br.com.cbgomes.adapter.input.api.response.CardsCustomerResponse;
import br.com.cbgomes.adapter.input.api.response.CreditRaterResponse;
import br.com.cbgomes.adapter.input.api.response.EvaluationResultCustomerResponse;
import br.com.cbgomes.adapter.output.broker.domain.DataIssuanceCard;
import br.com.cbgomes.adapter.output.broker.producer.PublisherNotificationCardClientPort;
import br.com.cbgomes.adapter.output.feign.CardCustomerServiceClient;
import br.com.cbgomes.adapter.output.feign.CustomerRaterCreditServiceClient;
import br.com.cbgomes.adapter.output.feign.response.CustomerDataResponseClient;
import br.com.cbgomes.adapter.output.feign.response.CustomerRepresentationResponse;
import br.com.cbgomes.application.ports.input.ICustomerRaterCreditUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@Slf4j
public class CustomerRaterCreditController implements CustomerRaterCreditApi {

    private final ICustomerRaterCreditUseCase useCaseCustomerCredit;

    private final CardCustomerServiceClient cardCustomerServiceClient;
    private final CustomerRaterCreditServiceClient customerRaterCreditServiceClient;
    private final PublisherNotificationCardClientPort publisherNotificationCardClientPort;

    @Override
    public String create(CustomerRaterCreditRequest customerRaterCreditRequest) {
        return useCaseCustomerCredit.createCreditCardCustomer(customerRaterCreditRequest.toDomain(customerRaterCreditRequest));
    }

    @Override
    public ResponseEntity<CreditRaterResponse> customerCreditRater(String document) {
        var response = useCaseCustomerCredit.raterCreditCustomer(document);
        return ResponseEntity.ok(response.toResponse(response));
    }

    @Override
    public ResponseEntity<CustomerRepresentationResponse> getCustomer(String document) {
        try {
             var customer = this.customerRaterCreditServiceClient.giveCustomerClient(document);
             var cards = this.cardCustomerServiceClient.cardsCustomer(document);
            return ResponseEntity.ok(
                    CustomerRepresentationResponse.builder()
                            .cards(cards.getBody())
                            .customerDataResponse(customer.getBody())
                            .build());

        }catch (FeignException.FeignClientException exception){
            log.error("Error to calling data customers and cards: {} :{}", document, exception.getMessage());
        }
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public EvaluationResultCustomerResponse carryOutEvaluation(DataEvaluationCustomer dataEvaluationCustomer) {

        var customerData =
                this.customerRaterCreditServiceClient.giveCustomerClient(dataEvaluationCustomer.getDocument());

        var cardsCustomer
                = this.cardCustomerServiceClient.cardsCustomerByIncome(dataEvaluationCustomer.getIncome());

        customerData.getBody();
        List<CardApprovedResponse> cardsApprovedToCustomer = cardsCustomer.getBody();
        final List<CardApprovedResponse> cards_approved_customer = cardsApprovedToCustomer.stream()
                .map(card -> {

                    return getCardApprovedResponseCustomer(customerData, card);

                }).collect(Collectors.toList());

        return new EvaluationResultCustomerResponse(cards_approved_customer);
    }

    @Override
    public ResponseEntity<String> issuanceCardToCustomer(DataIssuanceCardRequest dataIssuanceCardRequest) throws JsonProcessingException {
        final DataIssuanceCard issuance = DataIssuanceCard.builder()
                .id(dataIssuanceCardRequest.getId())
                .card_limit(dataIssuanceCardRequest.getCard_limit())
                .address(dataIssuanceCardRequest.getAddress())
                .document(dataIssuanceCardRequest.getDocument())
                .build();
        this.publisherNotificationCardClientPort.sendNotificationIssuanceCard(issuance);

        return ResponseEntity.ok(UUID.randomUUID().toString());
    }

    private CardApprovedResponse getCardApprovedResponseCustomer(ResponseEntity<CustomerDataResponseClient> customerData, CardApprovedResponse card) {
        CustomerDataResponseClient data_customer = customerData.getBody();

        var limit_card = card.getCard_limit_customer();
        var age_customer = BigDecimal.valueOf(data_customer.getAge());

        var factor = age_customer.divide(BigDecimal.valueOf(10));
        var limit_approved_to_customer = factor.multiply(limit_card);


        CardApprovedResponse approved = CardApprovedResponse.builder()
                .id(card.getId())
                .card_limit_customer(limit_approved_to_customer)
                .flag(card.getFlag())
                .name_card(card.getName_card())
                .build();
        return approved;
    }

}
