package br.com.cbgomes.controller.request;

import br.com.cbgomes.enums.FlagCard;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class CardRequest {

    private String name;

    private FlagCard flag_card;

    private BigDecimal income;

    private BigDecimal card_limit;
}
