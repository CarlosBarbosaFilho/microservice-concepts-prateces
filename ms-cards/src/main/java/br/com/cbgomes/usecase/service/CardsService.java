package br.com.cbgomes.usecase.service;

import br.com.cbgomes.controller.request.CardRequest;
import br.com.cbgomes.controller.response.CardApprovedResponse;
import br.com.cbgomes.domain.Card;
import br.com.cbgomes.infra.repository.CardsRepository;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CardsService {

    private final CardsRepository cardsRepository;

    public Card create(CardRequest cardRequest){
        return this.cardsRepository.save(
                Card.builder()
                        .name(cardRequest.getName())
                        .flag_card(cardRequest.getFlag_card())
                        .income(cardRequest.getIncome())
                        .card_limit(cardRequest.getCard_limit())
                        .build()
        );
    }

    public List<CardApprovedResponse> cards(Long income) {
        var incomeConvert = BigDecimal.valueOf(income);
        List<CardApprovedResponse> cards = new ArrayList<>();
         return this.cardsRepository.findByIncomeLessThanEqual(incomeConvert)
                .stream().map(it -> CardApprovedResponse.builder()
                         .id(it.getId())
                         .name_card(it.getName())
                         .flag(it.getFlag_card().name())
                         .card_limit_customer(it.getCard_limit())
                         .build()).toList();
    }
}
