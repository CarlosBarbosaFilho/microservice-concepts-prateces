package br.com.cbgomes.application.ports.input;

import br.com.cbgomes.adapter.output.feign.response.CustomerData;
import br.com.cbgomes.application.domain.CustomerRaterCreditDomain;
import org.springframework.http.ResponseEntity;

public interface ICustomerRaterCreditUseCase {

     String createCreditCardCustomer(CustomerRaterCreditDomain customerRaterCreditDomain);

     CustomerRaterCreditDomain raterCreditCustomer(String document);

     ResponseEntity<CustomerData> getCustomer(String document);
}
