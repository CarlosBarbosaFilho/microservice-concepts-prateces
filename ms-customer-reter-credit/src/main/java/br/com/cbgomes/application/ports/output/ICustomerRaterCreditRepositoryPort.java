package br.com.cbgomes.application.ports.output;


import br.com.cbgomes.application.domain.CustomerRaterCreditDomain;

public interface ICustomerRaterCreditRepositoryPort {

    void createCreditCardCustomer(CustomerRaterCreditDomain customerRaterCreditDomain);

    CustomerRaterCreditDomain raterCreditCardCustomer(String document);

}
