package br.com.cbgomes.application.ports.output;

import br.com.cbgomes.adapter.output.feign.response.CustomerDataResponseClient;

public interface ICustomerClientPort {

    CustomerDataResponseClient getCustomer(String document);
}
