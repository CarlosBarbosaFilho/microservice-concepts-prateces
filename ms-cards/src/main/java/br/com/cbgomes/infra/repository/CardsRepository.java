package br.com.cbgomes.infra.repository;

import br.com.cbgomes.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface CardsRepository extends JpaRepository<Card, Long> {

     List<Card> findByIncomeLessThanEqual(BigDecimal income);
}
