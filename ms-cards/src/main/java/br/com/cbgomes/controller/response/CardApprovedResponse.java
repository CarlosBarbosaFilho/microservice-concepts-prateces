package br.com.cbgomes.controller.response;


import br.com.cbgomes.domain.CardCustomer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardApprovedResponse {

    private Long id;

    private String flag;

    private String name_card;

    private BigDecimal card_limit_customer;


    public static CardApprovedResponse fromCardCustomer(CardCustomer cardCustomer){
        return CardApprovedResponse.builder()
                .id(cardCustomer.getId())
                .name_card(cardCustomer.getCard().getName())
                .card_limit_customer(cardCustomer.getCard_limit_customer())
                .flag(cardCustomer.getCard().getFlag_card().toString()).build();
    }
}
