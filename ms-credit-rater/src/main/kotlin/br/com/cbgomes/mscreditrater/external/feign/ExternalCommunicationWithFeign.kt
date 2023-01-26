package br.com.cbgomes.mscreditrater.external.feign

import br.com.cbgomes.mscreditrater.controller.response.CreditRaterResponse
import br.com.cbgomes.mscreditrater.controller.response.DataCustomer
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "ms-customer",
    url = "http://localhost:9080/api/v1/"
)
interface ExternalCommunicationWithFeign {

    @RequestMapping(params = ["document"], path = ["customers/"])
    fun giveCustomerClient(@RequestParam document: String): ResponseEntity<CreditRaterResponse>
}