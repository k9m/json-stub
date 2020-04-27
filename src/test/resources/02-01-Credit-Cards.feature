Feature: System starts

  Background:
    Given the system has started up

  Scenario: Retrieving a credit card account should display the correct details
    When retrieving a credit card account with id 1
    Then the following credit card details should match
      | id | cardNumber | sequenceNumber | cardHolder | status | monthlyLimit |
      | 1  | 5075       | 1              | Boromir    | ACTIVE | 3000         |
    When retrieving a credit card account with id 2
    Then the following credit card details should match
      | id | cardNumber | sequenceNumber | cardHolder | status  | monthlyLimit |
      | 2  | 5099       | 2              | Faramir    | BLOCKED | 4000         |


  Scenario: Retrieving a credit card account should display the correct details
    When retrieving a credit card account with id 99999
    Then an error should be returned with message containing: Couldn't find CREDIT card with id: 99999 and status code: 404
