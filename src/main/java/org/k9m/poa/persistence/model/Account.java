package org.k9m.poa.persistence.model;

import lombok.Data;
import org.k9m.poa.api.model.AccountDTO;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity(name = "accounts")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String iban;
  private Double balance;
  private String owner;
  private LocalDate created;
  private LocalDate ended;


  public AccountDTO toApiModel(){
    final AccountDTO accountDTO = new AccountDTO();
    BeanUtils.copyProperties(this, accountDTO);
    return accountDTO;
  }

}

