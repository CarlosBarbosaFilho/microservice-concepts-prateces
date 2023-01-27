package br.com.cbgomes.adapter.output.feign.service;

import br.com.cbgomes.adapter.output.feign.response.CustomerDataResponseClient;
import br.com.cbgomes.application.ports.output.ICustomerClientPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerRaterCreditServiceClient implements ICustomerClientPort {

    private final br.com.cbgomes.adapter.output.feign.CustomerRaterCreditServiceClient customerRaterCreditServiceClient;

    @Override
    public CustomerDataResponseClient getCustomer(String document) {
        return this.customerRaterCreditServiceClient.giveCustomerClient(document)
                .getBody();
    }
}
