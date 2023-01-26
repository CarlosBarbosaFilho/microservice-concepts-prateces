package br.com.cbgomes.adapter.input.api.request;

import br.com.cbgomes.application.domain.DataEvaluationCustomerDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataEvaluationCustomer {

    private String document;
    private Long income;

    public ResponseEntity<DataEvaluationCustomer> toDataEvaluationCustomer(DataEvaluationCustomerDomain dataEvaluationCustomerDomain) {
        return ResponseEntity.ok(DataEvaluationCustomer.builder()
                .document(dataEvaluationCustomerDomain.getDocument())
                .income(dataEvaluationCustomerDomain.getIncome())
                .build());
    }

    public ResponseEntity<DataEvaluationCustomerDomain> toDataEvaluationCustomerDomain(DataEvaluationCustomer dataEvaluationCustomer) {
        return ResponseEntity.ok(DataEvaluationCustomerDomain.builder()
                .document(dataEvaluationCustomer.getDocument())
                .income(dataEvaluationCustomer.getIncome())
                .build());
    }
}
