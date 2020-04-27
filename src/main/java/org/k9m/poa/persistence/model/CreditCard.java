package org.k9m.poa.persistence.model;

import lombok.Data;
import org.k9m.poa.api.model.CreditCardDTO;
import org.k9m.poa.api.model.StatusDTO;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@Entity(name = "credit_cards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer cardNumber;
    private Integer sequenceNumber;
    private String cardHolder;
    private String status;
    private Integer monthlyLimit;

    public CreditCardDTO toApiModel(){
        final CreditCardDTO creditCard = new CreditCardDTO();
        BeanUtils.copyProperties(this, creditCard);

        creditCard.status(StatusDTO.fromValue(status));

        return creditCard;
    }

}
