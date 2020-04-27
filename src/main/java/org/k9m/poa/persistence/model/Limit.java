package org.k9m.poa.persistence.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "limits")
public class Limit {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Integer amount;
  private String periodUnit;


}

