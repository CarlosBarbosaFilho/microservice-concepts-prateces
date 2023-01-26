package br.com.cbgomes.mscustomer.controller;

import br.com.cbgomes.mscustomer.controller.request.CustomerRequest;
import br.com.cbgomes.mscustomer.controller.response.CustomerData;
import br.com.cbgomes.mscustomer.controller.response.CustomerRepresentationResponse;
import br.com.cbgomes.mscustomer.domain.Customer;
import br.com.cbgomes.mscustomer.usecase.sevice.CustomerUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/customers/")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public ResponseEntity createCustomer(@RequestBody CustomerRequest customerRequest) {
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("document={document}")
                .buildAndExpand(this.customerUseCase.save(customerRequest).getDocument())
                .toUri();
        return ResponseEntity.created(headerLocation).build();

    }

    @GetMapping(params = "document")
    @ResponseStatus( HttpStatus.OK)
    public ResponseEntity<CustomerData> customer(@RequestParam String document) {
        try {
            Customer customer = this.customerUseCase.customerDocument(document);
            if (customer == null) {
                return ResponseEntity.notFound().build();
            }else {
                return ResponseEntity.ok(CustomerData.
                        builder()
                        .id(customer.getId())
                        .age(customer.getAge())
                        .name(customer.getName())
                        .document(customer.getDocument())
                        .build());
            }
        }catch (HttpClientErrorException exception) {
            ResponseEntity.notFound().build();
        }

        return null;
    }
}
