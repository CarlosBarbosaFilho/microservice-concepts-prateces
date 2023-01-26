package br.com.cbgomes.mscreditrater.controller.response

import java.math.BigDecimal

data class CardCustomer(
    private val name: String,
    private val flag: String,
    private val limit_card_customer: BigDecimal
)
