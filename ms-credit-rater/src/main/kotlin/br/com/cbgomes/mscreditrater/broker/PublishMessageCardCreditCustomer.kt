package br.com.cbgomes.mscreditrater.broker

import org.hibernate.query.sqm.tree.SqmNode.log
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class PublishMessageCardCreditCustomer(private val rabbitTemplate: RabbitTemplate, private  val queue: Queue) {

    fun publish(payload: MessageCustom?) {
        this.rabbitTemplate.convertAndSend(payload!!)
    }
}