package br.com.cbgomes.adapter.input.api.response;

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

}
