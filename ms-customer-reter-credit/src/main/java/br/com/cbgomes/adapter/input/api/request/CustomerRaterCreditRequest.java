package br.com.cbgomes.adapter.input.api.request;


import br.com.cbgomes.application.domain.CustomerRaterCreditDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRaterCreditRequest {

    private Long id_card;
    private String document;
    private String address;

    public CustomerRaterCreditDomain toDomain(CustomerRaterCreditRequest customerRaterCreditRequest) {
        return CustomerRaterCreditDomain.builder()
                .id_card(customerRaterCreditRequest.getId_card())
                .document(customerRaterCreditRequest.getDocument())
                .address(customerRaterCreditRequest.getAddress())
                .build();
    }
}
