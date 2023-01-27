package br.com.cbgomes.application.service;

import br.com.cbgomes.adapter.input.api.response.EvaluationResultCustomerResponse;
import br.com.cbgomes.application.domain.CustomerRaterCreditDomain;
import br.com.cbgomes.application.ports.input.ICustomerRaterCreditUseCase;
import br.com.cbgomes.application.ports.output.ICustomerRaterCreditRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;


@Service
@AllArgsConstructor
public class CustomerRaterCreditService implements ICustomerRaterCreditUseCase {

    private final ICustomerRaterCreditRepositoryPort iCustomerRaterCreditRepositoryPort;

    @Override
    public String createCreditCardCustomer(CustomerRaterCreditDomain customerRaterCreditDomain) {
        customerRaterCreditDomain.create(iCustomerRaterCreditRepositoryPort);
        return this.generateProtocol(customerRaterCreditDomain);
    }

    @Override
    public CustomerRaterCreditDomain raterCreditCustomer(String document) {
        return iCustomerRaterCreditRepositoryPort.raterCreditCardCustomer(document);
    }

    private String generateProtocol(CustomerRaterCreditDomain customerRaterCreditDomain) {
       return customerRaterCreditDomain
               .getDocument() + customerRaterCreditDomain
               .getId_card() + UUID.randomUUID();
   }
}
