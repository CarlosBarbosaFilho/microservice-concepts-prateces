package br.com.cbgomes.usecase.service;

import br.com.cbgomes.controller.request.CardCustomerRequest;
import br.com.cbgomes.controller.response.CardCustomerResponse;
import br.com.cbgomes.domain.CardCustomer;
import br.com.cbgomes.infra.repository.CardCustomerRepository;
import br.com.cbgomes.infra.repository.CardsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CardCustomerService {

    private final CardCustomerRepository cardCustomerRepository;
    private final CardsRepository cardsRepository;

    public void createCardToCustomer(CardCustomerRequest customerRequest) {
        var card = this.cardsRepository.findById(customerRequest.getCard().getId())
                .orElseThrow(() -> new NoSuchElementException("Card not exist, please insert other card number"));
        this.cardCustomerRepository.save(CardCustomer.builder()
                        .card(card)
                        .document(customerRequest.getDocument())
                        .card_limit_customer(customerRequest.getCard_limit_customer())
                .build());
    }

    public List<CardCustomerResponse> cardsCustomerDocument(String document) {
        var cardsCustomer = this.cardCustomerRepository.findByDocument(document);
        return cardsCustomer.stream()
                .map(CardCustomerResponse::fromCardCustomer)
                .collect(Collectors.toList());
    }
}
