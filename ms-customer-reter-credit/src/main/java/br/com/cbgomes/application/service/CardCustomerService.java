package br.com.cbgomes.application.service;

import br.com.cbgomes.adapter.input.api.response.CardsCustomerResponse;
import br.com.cbgomes.application.ports.input.ICardCustomerUseCase;
import br.com.cbgomes.application.ports.output.ICardClientPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class CardCustomerService implements ICardCustomerUseCase {

    private final ICardClientPort iCardClientPort;

    @Override
    public List<CardsCustomerResponse> getCardsCustomer(String document) {

        var cards_customers_responses = new ArrayList<CardsCustomerResponse>();
        Objects.requireNonNull(iCardClientPort.getCard(document).getBody()).stream()
                .map(cards_customers_responses::add)
                .collect(Collectors.toList());

        return cards_customers_responses;
    }
}
