package br.com.cbgomes.controller;

import br.com.cbgomes.controller.request.CardRequest;
import br.com.cbgomes.controller.response.CardApprovedResponse;
import br.com.cbgomes.domain.Card;
import br.com.cbgomes.usecase.service.CardCustomerService;
import br.com.cbgomes.usecase.service.CardsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cards/")
@AllArgsConstructor
@Slf4j
public class CardsController {

    private final CardsService cardsService;
    private final CardCustomerService cardCustomerService;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody CardRequest cardRequest) {
        return ResponseEntity.ok(this.cardsService.create(cardRequest));
    }

    @GetMapping("income/{income}")
    public ResponseEntity<List<CardApprovedResponse>> cards(@PathVariable("income") Long income){
        return ResponseEntity.ok(this.cardsService.cards(income));
    }

    @GetMapping("document/{document}")
    public ResponseEntity<List<CardApprovedResponse>> cardsCustomer(@PathVariable("document") String document) {
        return ResponseEntity.ok(this.cardCustomerService.cardsCustomerDocument(document));
    }
}
