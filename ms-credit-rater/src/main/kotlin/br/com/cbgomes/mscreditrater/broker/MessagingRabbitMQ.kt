package br.com.cbgomes.mscreditrater.broker

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class MessagingRabbitMQ() {

    val TOPIC_EXCHANGE: String = "topicExchange"

    val QUEUE_NAME : String = "card-credit-customer"

    @Bean
    fun queue(): Queue {
        return Queue(QUEUE_NAME, false)
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(TOPIC_EXCHANGE)
    }

    @Bean
    fun binding(queue: Queue, topicExchange: TopicExchange): Binding {
        return BindingBuilder.bind(queue).to(topicExchange).with("rk.card.credit.customer");
    }

    @Bean
    fun producerJackson2MessageConverter(): Jackson2JsonMessageConverter? {
        return Jackson2JsonMessageConverter()
    }
}