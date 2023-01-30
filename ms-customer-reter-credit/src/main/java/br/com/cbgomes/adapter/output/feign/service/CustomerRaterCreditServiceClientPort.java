package br.com.cbgomes.adapter.output.feign.service;

import br.com.cbgomes.adapter.output.feign.CustomerRaterCreditServiceClient;
import br.com.cbgomes.adapter.output.feign.response.CustomerDataResponseClient;
import br.com.cbgomes.application.ports.output.ICustomerClientPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerRaterCreditServiceClientPort implements ICustomerClientPort {

    private final CustomerRaterCreditServiceClient customerRaterCreditServiceClient;


    @Override
    public ResponseEntity<CustomerDataResponseClient> getCustomer(String document) {
        return customerRaterCreditServiceClient.giveCustomerClient(document);
    }
}
