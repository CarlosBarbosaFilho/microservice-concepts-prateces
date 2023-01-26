package br.com.cbgomes.mscustomer.usecase.sevice;

import br.com.cbgomes.mscustomer.controller.request.CustomerRequest;
import br.com.cbgomes.mscustomer.domain.Customer;
import br.com.cbgomes.mscustomer.infra.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerUseCase {

    private final CustomerRepository customerRepository;

    public Customer save(CustomerRequest customerRequest) {
        return this.customerRepository.save(Customer
                .builder()
                        .name(customerRequest.getName())
                        .age(customerRequest.getAge())
                        .document(customerRequest.getDocument())
                .build());
    }

    public Customer customerDocument(String document){
        return this.customerRepository.getCustomerByDocument(document);
    }
}
