package org.k9m.poa.persistence.model;

import lombok.Data;
import org.k9m.poa.api.model.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@Entity(name = "debit_cards")
public class DebitCard {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer cardNumber;
    private Integer sequenceNumber;
    private String cardHolder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "atm_limit_id", referencedColumnName = "id")
    private Limit atmLimit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pos_limit_id", referencedColumnName = "id")
    private Limit posLimit;

    private String status;
    private Boolean contactless;

    public DebitCardDTO toApiModel(){
        DebitCardDTO debitCard = new DebitCardDTO();
        BeanUtils.copyProperties(this, debitCard);

        debitCard
                .status(StatusDTO.fromValue(status))
                .atmLimit(new LimitDTO()
                        .limit(atmLimit.getAmount())
                        .periodUnit(PeriodUnitDTO.fromValue(atmLimit.getPeriodUnit()))
                )
                .posLimit(new LimitDTO()
                        .limit(posLimit.getAmount())
                        .periodUnit(PeriodUnitDTO.fromValue(posLimit.getPeriodUnit()))
                );

        return debitCard;
    }

}
