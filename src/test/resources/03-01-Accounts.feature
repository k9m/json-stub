Feature: Accounts

  Background:
    Given the system has started up

  Scenario: Retrieving an account should display the correct details
    When retrieving an account with id 1
    Then the following account details should match
      | id | iban              | balance | owner                | created    |
      | 1  | NL23RABO123456789 | -125.00 | Super duper employee | 2007-10-12 |
    When retrieving an account with id 4
    Then the following account details should match
      | id | iban              | balance | owner               | created    | ended      |
      | 4  | NL23RABO123123123 | 0.00    | Super duper company | 2007-10-12 | 2019-09-01 |


  Scenario: Retrieving an account should display the correct details
    When retrieving an account with id 99999
    Then an error should be returned with message containing: Couldn't find ACCOUNT with id: 99999 and status code: 404
