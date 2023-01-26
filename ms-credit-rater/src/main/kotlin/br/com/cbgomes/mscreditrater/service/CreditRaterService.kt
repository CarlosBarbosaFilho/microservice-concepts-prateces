package br.com.cbgomes.mscreditrater.service

import br.com.cbgomes.mscreditrater.broker.PublishMessageCardCreditCustomer
import br.com.cbgomes.mscreditrater.controller.request.CardCustomerCreatedRequest
import br.com.cbgomes.mscreditrater.controller.request.toDomain
import br.com.cbgomes.mscreditrater.controller.response.CreditRaterResponse
import br.com.cbgomes.mscreditrater.controller.response.DataCustomer
import br.com.cbgomes.mscreditrater.domain.CardCustomerCreated
import br.com.cbgomes.mscreditrater.external.feign.ExternalCommunicationWithFeign
import br.com.cbgomes.mscreditrater.infra.repository.CardCustomerCreatedRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditRaterService(private  val cardCustomerCreatedRepository: CardCustomerCreatedRepository
, private val publishMessageCardCreditCustomer: PublishMessageCardCreditCustomer,
  private val externalCommunicationWithFeign: ExternalCommunicationWithFeign) {

    fun createCardCustomer(cardCustomerCreatedRequest: CardCustomerCreatedRequest): String {
        val domain = this.cardCustomerCreatedRepository.save(cardCustomerCreatedRequest.toDomain())
//        val message = MessageCustom(
//            idCard = domain.idCard,
//            document = domain.document,
//            address = domain.address
//        )
//        this.publishMessageCardCreditCustomer.publish(message, )
        return createProtocolCardCustomerCreated(domain)
    }

    private fun createProtocolCardCustomerCreated(customerCreated: CardCustomerCreated): String {
        return (customerCreated.document + customerCreated.idCard).plus(
            UUID.randomUUID()
        )
    }

    fun giveRaterCustomer(document: String): ResponseEntity<CreditRaterResponse> {
        return this.externalCommunicationWithFeign.giveCustomerClient(document)
    }
}