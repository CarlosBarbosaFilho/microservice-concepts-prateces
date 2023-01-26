package br.com.cbgomes.adapter.output.h2.repository;

import br.com.cbgomes.adapter.output.h2.entity.CustomerRaterCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRaterCreditRepository extends JpaRepository<CustomerRaterCredit, Long> {

    CustomerRaterCredit  getCustomerByDocument(String document);
}
