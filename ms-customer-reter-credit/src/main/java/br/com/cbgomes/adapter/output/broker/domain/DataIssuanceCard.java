package br.com.cbgomes.adapter.output.broker.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class DataIssuanceCard {

    private Long id;
    private String document;
    private String address;
    private BigDecimal card_limit;
}
