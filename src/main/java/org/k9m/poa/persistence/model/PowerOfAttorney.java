package org.k9m.poa.persistence.model;

import lombok.Data;
import org.k9m.poa.api.model.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Entity(name = "power_of_attorney")
public class PowerOfAttorney {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String grantor;
  private String grantee;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "account_id", referencedColumnName = "id")
  private Account account;

  private String direction;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
          name = "auth_poa",
          joinColumns = { @JoinColumn(name = "poa_id") },
          inverseJoinColumns = { @JoinColumn(name = "auth_id") }
  )
  private List<Authorization> authorizations;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
          name = "debit_cards_poa",
          joinColumns = { @JoinColumn(name = "poa_id") },
          inverseJoinColumns = { @JoinColumn(name = "dc_id") }
  )
  private List<DebitCard> debitCards;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
          name = "credit_cards_poa",
          joinColumns = { @JoinColumn(name = "poa_id") },
          inverseJoinColumns = { @JoinColumn(name = "cc_id") }
  )
  private List<CreditCard> creditCards;

  public PowerOfAttorneyDTO toApiModel() {
    return new PowerOfAttorneyDTO()
            .id(id)
            .grantor(grantor)
            .grantee(grantee)
            .direction(DirectionDTO.fromValue(direction))
            .account(account.getIban())
            .authorizations(authorizations.stream().map(a -> AuthorizationDTO.fromValue(a.getAuthValue())).collect(Collectors.toList()))
            .cards(Stream.concat(
                    debitCards.stream().map(dc -> new CardReferenceDTO().id(dc.getId()).type(CardTypeDTO.DEBIT_CARD)),
                    creditCards.stream().map(cc -> new CardReferenceDTO().id(cc.getId()).type(CardTypeDTO.CREDIT_CARD)))
                    .collect(Collectors.toList()));
  }
}

