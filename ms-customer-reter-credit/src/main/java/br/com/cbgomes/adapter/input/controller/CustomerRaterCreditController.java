package br.com.cbgomes.adapter.input.controller;

import br.com.cbgomes.adapter.input.api.CustomerRaterCreditApi;
import br.com.cbgomes.adapter.input.api.request.CustomerRaterCreditRequest;
import br.com.cbgomes.adapter.input.api.request.DataEvaluationCustomer;
import br.com.cbgomes.adapter.input.api.response.CreditRaterResponse;
import br.com.cbgomes.adapter.input.api.response.EvaluationResultCustomerResponse;
import br.com.cbgomes.adapter.output.feign.response.CustomerRepresentationResponse;
import br.com.cbgomes.application.ports.input.ICardCustomerUseCase;
import br.com.cbgomes.application.ports.input.ICustomerRaterCreditUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@Slf4j
public class CustomerRaterCreditController implements CustomerRaterCreditApi {

    private final ICustomerRaterCreditUseCase useCaseCustomerCredit;
    private final ICardCustomerUseCase useCaseCustomerCard;

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
            var customerData = this.useCaseCustomerCredit.getCustomer(document);
            return ResponseEntity.ok(CustomerRepresentationResponse.builder()
                .customerData(customerData.getBody())
                .cards(useCaseCustomerCard.getCardsCustomer(document).getBody())
                .build());
    }

    @Override
    public ResponseEntity<EvaluationResultCustomerResponse> carryOutEvaluation(DataEvaluationCustomer dataEvaluationCustomer) {
        return null;
    }
}
