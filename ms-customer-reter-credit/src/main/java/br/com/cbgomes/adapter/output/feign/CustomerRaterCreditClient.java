package br.com.cbgomes.adapter.output.feign;

import br.com.cbgomes.adapter.input.api.response.CreditRaterResponse;
import br.com.cbgomes.adapter.output.feign.response.CustomerData;
import br.com.cbgomes.adapter.output.feign.response.CustomerRepresentationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "ms-customer",
        url = "http://localhost:9080/api/v1/"
)
public interface CustomerRaterCreditClient {

    @RequestMapping (params ="document", path = "customers/")
    ResponseEntity<CustomerData> giveCustomerClient(@RequestParam String document);
}
