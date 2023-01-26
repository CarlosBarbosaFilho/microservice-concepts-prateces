package br.com.cbgomes.application.service;

import br.com.cbgomes.adapter.input.api.response.CardsCustomerResponse;
import br.com.cbgomes.application.ports.input.ICardCustomerUseCase;
import br.com.cbgomes.application.ports.output.ICardClientPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CardCustomerService implements ICardCustomerUseCase {

    private final ICardClientPort iCardClientPort;

    @Override
    public ResponseEntity<List<CardsCustomerResponse>> getCardsCustomer(String document) {
        return iCardClientPort.getCard(document);
    }
}
