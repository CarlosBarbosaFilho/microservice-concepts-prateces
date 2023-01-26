package br.com.cbgomes.application.service;

import br.com.cbgomes.adapter.output.feign.response.CustomerData;
import br.com.cbgomes.application.domain.CustomerRaterCreditDomain;
import br.com.cbgomes.application.exceptions.CustomerNotFoundException;
import br.com.cbgomes.application.ports.input.ICustomerRaterCreditUseCase;
import br.com.cbgomes.application.ports.output.ICardClientPort;
import br.com.cbgomes.application.ports.output.ICustomerClientPort;
import br.com.cbgomes.application.ports.output.ICustomerRaterCreditRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.UUID;


@Service
@AllArgsConstructor
public class CustomerRaterCreditService implements ICustomerRaterCreditUseCase {

    private final ICustomerRaterCreditRepositoryPort iCustomerRaterCreditRepositoryPort;
    private final ICustomerClientPort iCustomerClientPort;
    private final ICardClientPort iCardClientPort;

    @Override
    public String createCreditCardCustomer(CustomerRaterCreditDomain customerRaterCreditDomain) {
        customerRaterCreditDomain.create(iCustomerRaterCreditRepositoryPort);
        return this.generateProtocol(customerRaterCreditDomain);
    }

    @Override
    public CustomerRaterCreditDomain raterCreditCustomer(String document) {
        return iCustomerRaterCreditRepositoryPort.raterCreditCardCustomer(document);
    }

    @Override
    public ResponseEntity<CustomerData> getCustomer(String document) throws CustomerNotFoundException {
           return this.iCustomerClientPort.getCustomer(document);
    }

    private String generateProtocol(CustomerRaterCreditDomain customerRaterCreditDomain) {
       return customerRaterCreditDomain
               .getDocument() + customerRaterCreditDomain
               .getId_card() + UUID.randomUUID();
   }

}
