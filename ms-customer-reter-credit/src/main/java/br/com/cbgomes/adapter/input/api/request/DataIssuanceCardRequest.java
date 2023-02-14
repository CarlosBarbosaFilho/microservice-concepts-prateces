package br.com.cbgomes.adapter.input.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DataIssuanceCardRequest {


    private Long id;
    private String document;
    private String address;
    private BigDecimal card_limit;
}
