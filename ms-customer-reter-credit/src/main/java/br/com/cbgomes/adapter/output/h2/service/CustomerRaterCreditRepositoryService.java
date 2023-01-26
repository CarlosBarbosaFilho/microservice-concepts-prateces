package br.com.cbgomes.adapter.output.h2.service;

import br.com.cbgomes.adapter.output.h2.repository.CustomerRaterCreditRepository;
import br.com.cbgomes.application.domain.CustomerRaterCreditDomain;
import br.com.cbgomes.application.ports.output.ICustomerRaterCreditRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerRaterCreditRepositoryService implements ICustomerRaterCreditRepositoryPort{

    private final CustomerRaterCreditRepository customerRaterCreditRepository;

    @Override
    public  void createCreditCardCustomer(CustomerRaterCreditDomain customerRaterCreditDomain) {
        this.customerRaterCreditRepository
                .save(customerRaterCreditDomain.toEntity(customerRaterCreditDomain));
    }

    @Override
    public CustomerRaterCreditDomain raterCreditCardCustomer(String document) {
        var response = customerRaterCreditRepository.getCustomerByDocument(document);
        return CustomerRaterCreditDomain.builder()
                .id(response.getId())
                .id_card(response.getId_card())
                .document(response.getDocument())
                .address(response.getAddress())
                .build();
    }
}