package br.com.cbgomes.adapter.output.broker.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueueConfiguration {

    @Value("${mq.queues.issuance_of_cards}")
    private String issuance_cards;

    @Bean
    public Queue sendMessageQueueIssuanceCart() {
        return new Queue(issuance_cards, true);
    }
}
