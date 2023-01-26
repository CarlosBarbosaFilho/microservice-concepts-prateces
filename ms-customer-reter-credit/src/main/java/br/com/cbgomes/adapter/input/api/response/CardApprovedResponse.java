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

    private String card;
    private String flag_card;
    private BigDecimal approve_limit;

}
