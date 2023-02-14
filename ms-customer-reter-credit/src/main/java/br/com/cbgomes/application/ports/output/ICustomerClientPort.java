package br.com.cbgomes.application.ports.output;

import br.com.cbgomes.adapter.output.feign.response.CustomerDataResponseClient;
import org.springframework.http.ResponseEntity;

public interface ICustomerClientPort {

    ResponseEntity<CustomerDataResponseClient> getCustomer(String document);
}
