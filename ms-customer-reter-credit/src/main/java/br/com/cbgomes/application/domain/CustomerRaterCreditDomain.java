package br.com.cbgomes.application.domain;


import br.com.cbgomes.adapter.input.api.response.CreditRaterResponse;
import br.com.cbgomes.adapter.output.h2.entity.CustomerRaterCredit;
import br.com.cbgomes.application.ports.output.ICustomerRaterCreditRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRaterCreditDomain {

    private Long id;
    private Long id_card;
    private String document;
    private String address;


    public void create(ICustomerRaterCreditRepositoryPort iCustomerRaterCreditRepositoryPort){
         iCustomerRaterCreditRepositoryPort.createCreditCardCustomer(this);
    }

    public CustomerRaterCredit toEntity(CustomerRaterCreditDomain customerRaterCreditDomain) {
      return  CustomerRaterCredit.builder()
                .id_card(customerRaterCreditDomain.getId_card())
                .document(customerRaterCreditDomain.getDocument())
                .address(customerRaterCreditDomain.getAddress())
                .build();
    }

    public CreditRaterResponse toResponse(CustomerRaterCreditDomain customerRaterCreditDomain) {
        return CreditRaterResponse.builder()
                .id(customerRaterCreditDomain.getId())
                .id_card(customerRaterCreditDomain.getId_card())
                .document(customerRaterCreditDomain.getDocument())
                .address(customerRaterCreditDomain.getAddress())
                .build();
    }
}
