package br.com.cbgomes.adapter.output.feign.service;

import br.com.cbgomes.adapter.output.feign.response.CustomerData;
import br.com.cbgomes.adapter.output.feign.CustomerRaterCreditClient;
import br.com.cbgomes.application.ports.output.ICustomerClientPort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceClientPort implements ICustomerClientPort {

    private final CustomerRaterCreditClient customerRaterCreditClient;

    @Override
    public ResponseEntity<CustomerData> getCustomer(String document) {
        return this.customerRaterCreditClient.giveCustomerClient(document);
    }
}
