package br.com.cbgomes.domain;

import br.com.cbgomes.enums.FlagCard;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="flag")
    @Enumerated(EnumType.STRING)
    private FlagCard flag_card;

    @Column(name="income")
    private BigDecimal income;

    @Column(name="card_limit")
    private BigDecimal card_limit;

}
