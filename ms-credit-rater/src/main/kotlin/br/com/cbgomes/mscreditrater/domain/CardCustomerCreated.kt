package br.com.cbgomes.mscreditrater.domain

import br.com.cbgomes.mscreditrater.controller.response.CardCustomerCreatedResponse
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class CardCustomerCreated(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val idCard: Long,
    val document: String,
    val address: String
 ){
    fun fromToDomainCardCustomerCreatedResponse(customerCreated: CardCustomerCreated) : CardCustomerCreatedResponse {
        return CardCustomerCreatedResponse(
            id = customerCreated.id,
            idCard = customerCreated.idCard,
            document = customerCreated.document,
            address = customerCreated.address
        )
    }

}
