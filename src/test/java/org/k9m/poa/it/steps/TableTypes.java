package org.k9m.poa.it.steps;

import io.cucumber.java.DataTableType;
import lombok.extern.slf4j.Slf4j;
import org.k9m.poa.api.model.*;

import java.time.LocalDate;
import java.util.Map;

@Slf4j
public class TableTypes {

    @DataTableType
    public DebitCardDTO debitCard(Map<String, String> entry) {
        return new DebitCardDTO()
                .id(Long.parseLong(entry.get("id")))
                .cardNumber(Integer.parseInt(entry.get("cardNumber")))
                .sequenceNumber(Integer.parseInt(entry.get("sequenceNumber")))
                .cardHolder(entry.get("cardHolder"))
                .status(StatusDTO.fromValue(entry.get("status")))
                .contactless(Boolean.valueOf(entry.get("contactless")))
                .atmLimit(new LimitDTO()
                        .limit(Integer.parseInt(entry.get("atm.limit")))
                        .periodUnit(PeriodUnitDTO.fromValue(entry.get("atm.periodUnit")))
                )
                .posLimit(new LimitDTO()
                        .limit(Integer.parseInt(entry.get("pos.limit")))
                        .periodUnit(PeriodUnitDTO.fromValue(entry.get("pos.periodUnit")))
                );
    }

    @DataTableType
    public CreditCardDTO creditCard(Map<String, String> entry) {
        return new CreditCardDTO()
                .id(Long.parseLong(entry.get("id")))
                .cardNumber(Integer.parseInt(entry.get("cardNumber")))
                .sequenceNumber(Integer.parseInt(entry.get("sequenceNumber")))
                .cardHolder(entry.get("cardHolder"))
                .status(StatusDTO.fromValue(entry.get("status")))
                .monthlyLimit(Integer.parseInt(entry.get("monthlyLimit")));
    }

    @DataTableType
    public AccountDTO account(Map<String, String> entry) {
        AccountDTO accountDTO = new AccountDTO()
                .id(Long.parseLong(entry.get("id")))
                .iban(entry.get("iban"))
                .balance(Double.parseDouble(entry.get("balance")))
                .owner(entry.get("owner"));

        try {
            accountDTO.created(LocalDate.parse(entry.get("created")));
            accountDTO.ended(LocalDate.parse(entry.get("ended")));
        } catch (Exception e) {/*NOOP*/}

        return accountDTO;
    }

}
