package br.com.cbgomes.adapter.output.feign;

import br.com.cbgomes.adapter.input.api.response.CardApprovedResponse;
import br.com.cbgomes.adapter.input.api.response.CardsCustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient (
        name = "ms-card",
        url = "http://localhost:9080/api/v1/cards/"
)
public interface CardCustomerServiceClient {

    @GetMapping ("document/{document}")
    ResponseEntity<List<CardsCustomerResponse>> cardsCustomer(@PathVariable String document);

    @GetMapping( "income/{income}")
    ResponseEntity<List<CardApprovedResponse>> cardsCustomerByIncome(@PathVariable Long income);
}
