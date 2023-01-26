package br.com.cbgomes.adapter.output.feign.service;

import br.com.cbgomes.adapter.input.api.response.CardsCustomerResponse;
import br.com.cbgomes.adapter.output.feign.CardCustomerClient;
import br.com.cbgomes.application.ports.output.ICardClientPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CardServiceClientPort implements ICardClientPort {


    private final CardCustomerClient cardCustomerClient;

    @Override
    public ResponseEntity<List<CardsCustomerResponse>> getCard(String document) {
        return this.cardCustomerClient.cardsCustomer(document);
    }
}
