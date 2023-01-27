package br.com.cbgomes.application.ports.input;

import br.com.cbgomes.application.domain.CustomerRaterCreditDomain;

public interface ICustomerRaterCreditUseCase {

     String createCreditCardCustomer(CustomerRaterCreditDomain customerRaterCreditDomain);

     CustomerRaterCreditDomain raterCreditCustomer(String document);

}