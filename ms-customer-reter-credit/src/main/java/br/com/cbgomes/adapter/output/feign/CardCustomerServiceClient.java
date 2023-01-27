package br.com.cbgomes.adapter.output.feign;

import br.com.cbgomes.adapter.input.api.response.CardApprovedResponse;
import br.com.cbgomes.adapter.input.api.response.CardsCustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient (
        name = "ms-card",
        url = "http://localhost:9080/api/v1/"
)
public interface CardCustomerServiceClient {

    @GetMapping (params = "document", path = "cards/")
    ResponseEntity<List<CardsCustomerResponse>> cardsCustomer(@RequestParam String document);

    @GetMapping(params = "income", path = "cards/")
    ResponseEntity<List<CardApprovedResponse>> cardsCustomerByIncome(@RequestParam Long income);
}
