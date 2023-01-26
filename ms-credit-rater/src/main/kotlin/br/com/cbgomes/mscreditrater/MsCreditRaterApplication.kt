package br.com.cbgomes.mscreditrater

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
@EnableFeignClients
class MsCreditRaterApplication

fun main(args: Array<String>) {
    runApplication<MsCreditRaterApplication>(*args)
}
