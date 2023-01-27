package br.com.cbgomes.application.ports.input;

import br.com.cbgomes.adapter.input.api.response.CardsCustomerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICardCustomerUseCase {

    List<CardsCustomerResponse> getCardsCustomer(String document);
}
