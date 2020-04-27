Feature: System starts

  Background:
    Given the system has started up

  Scenario: Retrieving a debit card account should display the correct details
    When retrieving a debit card account with id 1
    Then the following details should match
      | id | cardNumber | sequenceNumber | cardHolder    | status | contactless | atm.limit | atm.periodUnit | pos.limit | pos.periodUnit |
      | 1  | 1234       | 5              | Frodo Baggins | ACTIVE | true        | 3000      | PER_WEEK       | 50        | PER_MONTH      |
    When retrieving a debit card account with id 2
    Then the following details should match
      | id | cardNumber | sequenceNumber | cardHolder | status | contactless | atm.limit | atm.periodUnit | pos.limit | pos.periodUnit |
      | 2  | 6527       | 1              | Aragorn    | ACTIVE | true        | 100       | PER_DAY        | 10000     | PER_MONTH      |


  Scenario: Retrieving a debit card account should display the correct details
    When retrieving a debit card account with id 99999
    Then an error should be returned with message containing: Couldn't find DEBIT card with id: 99999 and status code: 404
