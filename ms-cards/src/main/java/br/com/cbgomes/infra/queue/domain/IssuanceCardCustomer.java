package br.com.cbgomes.infra.queue.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssuanceCardCustomer {

    private Long id;
    private String document;
    private String address;
    private BigDecimal card_limit;
}
