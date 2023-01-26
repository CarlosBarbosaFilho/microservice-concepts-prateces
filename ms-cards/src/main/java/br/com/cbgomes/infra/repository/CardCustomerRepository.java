package br.com.cbgomes.infra.repository;

import br.com.cbgomes.domain.CardCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardCustomerRepository extends JpaRepository<CardCustomer, Long> {

    List<CardCustomer> findByDocument(String document);
}
