package br.com.cbgomes.mscreditrater.controller.request

import br.com.cbgomes.mscreditrater.domain.CardCustomerCreated

data class CardCustomerCreatedRequest(
     val id_card: Long,
     val document: String,
     val address: String
)

fun CardCustomerCreatedRequest.toDomain() = CardCustomerCreated(
        id = null,
        idCard = id_card,
        document = document,
        address = address
    )

