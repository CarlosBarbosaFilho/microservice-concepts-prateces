package br.com.cbgomes.adapter.input.api;

import br.com.cbgomes.adapter.input.api.request.CustomerRaterCreditRequest;
import br.com.cbgomes.adapter.input.api.request.DataEvaluationCustomer;
import br.com.cbgomes.adapter.input.api.response.CreditRaterResponse;
import br.com.cbgomes.adapter.input.api.response.EvaluationResultCustomerResponse;
import br.com.cbgomes.adapter.output.feign.response.CustomerRepresentationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/rater-credit-customer/")
public interface CustomerRaterCreditApi {

    @PostMapping
    @ResponseStatus ( HttpStatus.CREATED)
    String create(@RequestBody CustomerRaterCreditRequest customerRaterCreditRequest);


   //@GetMapping (params ="document")
    ResponseEntity<CreditRaterResponse> customerCreditRater (@RequestParam String document);


    @GetMapping (params ="document")
    ResponseEntity<CustomerRepresentationResponse> getCustomer(@RequestParam String document);

    @PostMapping("/evaluate-customer")
    ResponseEntity<EvaluationResultCustomerResponse> carryOutEvaluation(@RequestBody DataEvaluationCustomer dataEvaluationCustomer);
}
