package br.com.cbgomes.infra.queue;

import br.com.cbgomes.domain.Card;
import br.com.cbgomes.domain.CardCustomer;
import br.com.cbgomes.infra.exceptions.CardNotFoundException;
import br.com.cbgomes.infra.queue.domain.IssuanceCardCustomer;
import br.com.cbgomes.infra.repository.CardCustomerRepository;
import br.com.cbgomes.infra.repository.CardsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ListenerQueueCardsIssuance {

    private static final Logger log = LoggerFactory.getLogger(ListenerQueueCardsIssuance.class);

    private final CardCustomerRepository cardCustomerRepository;
    private final CardsRepository cardsRepository;

    @RabbitListener(queues = "${mq.queues.issuance_of_cards}")
    public  void receiveIssuanceCard(String payload) {
        try {
            sendIssuanceCardCustomer(payload);
            log.info("Issuance received to customer: {}", payload);
        } catch (JsonProcessingException exception) {
            log.error("error to receive issuance card to customer {} : ", exception.getMessage());

        }

    }

    private void sendIssuanceCardCustomer(String payload) throws JsonProcessingException {
        log.info("receive message: issuance card to customer {} :", payload);
        ObjectMapper objectMapper = new ObjectMapper();
        final IssuanceCardCustomer issuanceCardCustomer = objectMapper.readValue(payload, IssuanceCardCustomer.class);
        final Optional<Card> card = Optional.ofNullable(this.cardsRepository.findById(issuanceCardCustomer.getId())
                .orElseThrow(() -> new CardNotFoundException("Not possible find the card, please report a new card")));

        var cardCustomerEntity = new CardCustomer();
        cardCustomerEntity.setCard(card.get());
        cardCustomerEntity.setCard_limit_customer(issuanceCardCustomer.getCard_limit());
        cardCustomerEntity.setDocument(issuanceCardCustomer.getDocument());
        this.cardCustomerRepository.save(cardCustomerEntity);
        log.info("registering the issuance card to customer: {}", cardCustomerEntity);

    }
}
