package br.com.cbgomes.mscreditrater.controller

import br.com.cbgomes.mscreditrater.controller.request.CardCustomerCreatedRequest
import br.com.cbgomes.mscreditrater.controller.response.CreditRaterResponse
import br.com.cbgomes.mscreditrater.service.CreditRaterService
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/credit-raters/")
class CreditRaterController(private val creditRaterService: CreditRaterService) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody cardCustomerCreatedRequest: CardCustomerCreatedRequest): String{
        return this.creditRaterService.createCardCustomer(cardCustomerCreatedRequest)
    }

    @GetMapping(params = ["document"])
    fun customerCreditRater(@RequestParam document: String): ResponseEntity<CreditRaterResponse> {
        return this.creditRaterService.giveRaterCustomer(document)
    }
}