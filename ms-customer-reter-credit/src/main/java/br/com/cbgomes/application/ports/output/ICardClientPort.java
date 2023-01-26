package br.com.cbgomes.application.ports.output;

import br.com.cbgomes.adapter.input.api.response.CardsCustomerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICardClientPort {

    ResponseEntity<List<CardsCustomerResponse>> getCard(String document);
}
