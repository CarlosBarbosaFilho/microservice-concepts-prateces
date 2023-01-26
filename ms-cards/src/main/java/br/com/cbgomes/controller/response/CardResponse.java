package br.com.cbgomes.controller.response;

import br.com.cbgomes.enums.FlagCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class CardResponse {

    private Long id;

    private String name;

    private FlagCard flag_card;

    private BigDecimal income;

    private BigDecimal card_limit;
}
