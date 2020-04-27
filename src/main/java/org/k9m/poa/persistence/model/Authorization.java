package org.k9m.poa.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "authorizations")
public class Authorization {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String authValue;


}

