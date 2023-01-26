package br.com.cbgomes.mscreditrater.controller.response

data class CreditRaterResponse(
  private val id: Long,
  private val name: String,
  private val cards: List<CardCustomer>?
)
