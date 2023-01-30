package br.com.cbgomes.adapter.output.broker.producer;

import br.com.cbgomes.adapter.output.broker.domain.DataIssuanceCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublisherPortNotificationIssuanceCard implements PublisherNotificationCardClientPort {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queueIssuanceCard;


    public void sendNotificationIssuanceCard(DataIssuanceCard dataIssuanceCard) throws JsonProcessingException {
        var json = convertToJson(dataIssuanceCard);
        rabbitTemplate.convertAndSend(queueIssuanceCard.getName(), json);
    }

    private String convertToJson(DataIssuanceCard dataIssuanceCard) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dataIssuanceCard);
    }
}
