package br.com.cbgomes.application.ports.output;

import br.com.cbgomes.adapter.output.feign.response.CustomerData;
import org.springframework.http.ResponseEntity;

public interface ICustomerClientPort {

    ResponseEntity<CustomerData> getCustomer(String document);
}
