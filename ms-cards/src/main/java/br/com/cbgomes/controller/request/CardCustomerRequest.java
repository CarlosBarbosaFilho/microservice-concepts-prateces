package br.com.cbgomes.controller.request;

import br.com.cbgomes.domain.Card;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class CardCustomerRequest {

    private String document;

    private Card card;

    private BigDecimal card_limit_customer;
}
