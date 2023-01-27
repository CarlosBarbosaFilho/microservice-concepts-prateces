package br.com.cbgomes.adapter.input.controller;

import br.com.cbgomes.adapter.input.api.CardCustomerApi;
import br.com.cbgomes.adapter.input.api.response.CardsCustomerResponse;
import br.com.cbgomes.application.ports.input.ICardCustomerUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class CardCustomerController implements CardCustomerApi {

    private final ICardCustomerUseCase iCardCustomerUseCase;

    @Override
    public ResponseEntity<List<CardsCustomerResponse>> getCardsCustomer(String document) {
        return ResponseEntity.ok(this.iCardCustomerUseCase.getCardsCustomer(document));
    }
}
