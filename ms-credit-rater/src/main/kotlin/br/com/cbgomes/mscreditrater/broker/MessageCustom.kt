package br.com.cbgomes.mscreditrater.broker

import com.fasterxml.jackson.annotation.JsonProperty


data class MessageCustom(

    @JsonProperty("idCard")
    private val idCard: Long,
    @JsonProperty("document")
    private val document: String,
    @JsonProperty("address")
    private val address: String,

)