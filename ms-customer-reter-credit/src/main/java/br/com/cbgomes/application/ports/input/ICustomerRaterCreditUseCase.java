package br.com.cbgomes.application.ports.input;

import br.com.cbgomes.adapter.output.broker.domain.DataIssuanceCard;
import br.com.cbgomes.application.domain.CustomerRaterCreditDomain;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ICustomerRaterCreditUseCase {

     String createCreditCardCustomer(CustomerRaterCreditDomain customerRaterCreditDomain);

     CustomerRaterCreditDomain raterCreditCustomer(String document);
}