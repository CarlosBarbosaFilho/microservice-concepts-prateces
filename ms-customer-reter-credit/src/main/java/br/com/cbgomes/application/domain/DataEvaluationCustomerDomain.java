package br.com.cbgomes.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataEvaluationCustomerDomain {

    private String document;
    private Long income;

}
