package br.com.cbgomes.adapter.input.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditRaterResponse {

    private Long id;
    private Long id_card;
    private String document;
    private String address;
}
