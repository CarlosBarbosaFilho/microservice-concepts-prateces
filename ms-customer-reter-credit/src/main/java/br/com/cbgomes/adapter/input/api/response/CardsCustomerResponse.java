package br.com.cbgomes.adapter.input.api.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data

public class CardsCustomerResponse {

    private String flag;

    private String name_card;

    private BigDecimal card_limit_customer;

    public List<CardApprovedResponse> toListCardApproved(List<CardsCustomerResponse> cardsCustomerResponses){
        return cardsCustomerResponses.stream()
                .map( it -> it.toCardApproved(it))
                .toList();
    }

    public CardApprovedResponse toCardApproved(CardsCustomerResponse cardsCustomerResponse) {
        return CardApprovedResponse.builder()
                .name_card(cardsCustomerResponse.getName_card())
                .flag(cardsCustomerResponse.getFlag())
                .card_limit_customer(cardsCustomerResponse.getCard_limit_customer())
                .build();
    }


}
