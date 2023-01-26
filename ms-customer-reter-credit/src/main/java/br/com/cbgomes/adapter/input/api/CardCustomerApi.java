package br.com.cbgomes.adapter.input.api;

import br.com.cbgomes.adapter.input.api.response.CardsCustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/v1/cards-customer")
public interface CardCustomerApi {

    @GetMapping(params = "document")
    ResponseEntity<List<CardsCustomerResponse>> getCardsCustomer(@RequestParam String document);
}
