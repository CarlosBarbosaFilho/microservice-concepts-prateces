package br.com.cbgomes.mscustomer.infra.repository;

import br.com.cbgomes.mscustomer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer getCustomerByDocument(String document);
}
