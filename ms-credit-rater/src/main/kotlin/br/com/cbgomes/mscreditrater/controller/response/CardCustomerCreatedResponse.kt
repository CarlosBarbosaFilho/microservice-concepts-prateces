package br.com.cbgomes.mscreditrater.controller.response

import br.com.cbgomes.mscreditrater.controller.request.CardCustomerCreatedRequest
import br.com.cbgomes.mscreditrater.domain.CardCustomerCreated

data class CardCustomerCreatedResponse(
    val id: Long?,
    val idCard: Long,
    val document: String,
    val address: String
)

fun CardCustomerCreated.toCardCustomerCreatedResponse() =
     CardCustomerCreatedResponse(
        id = id,
        idCard = idCard,
        document = document,
        address = address
    )

