package br.com.cbgomes.adapter.output.feign;

import br.com.cbgomes.adapter.output.feign.response.CustomerDataResponseClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "ms-customer",
        url = "http://localhost:9080/api/v1/"
)
public interface CustomerRaterCreditServiceClient {

    @GetMapping (params ="document", path = "customers/")
    ResponseEntity<CustomerDataResponseClient> giveCustomerClient(@RequestParam String document);
}
