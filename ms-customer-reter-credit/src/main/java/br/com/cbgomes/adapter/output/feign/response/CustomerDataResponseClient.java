package br.com.cbgomes.adapter.output.feign.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@Data
@ToString
@Builder
public class CustomerDataResponseClient {

    private Long id;
    private String name;
    private Integer age;

    public ResponseEntity<CustomerDataResponseClient> customerDataResponseResponse(CustomerDataResponseClient customerDataResponse){
        return ResponseEntity.ok(
                CustomerDataResponseClient.builder()
                        .id(customerDataResponse.getId())
                        .name(customerDataResponse.getName())
                        .build());
    }
}
