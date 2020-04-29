Feature: Power of Attorney

  Background:
    Given the system has started up

  Scenario: Retrieving a power of attorney should display the correct details
    When retrieving a power of attorney with id 1
    Then the following power of attorney details should match
      | id | grantor             | grantee                | account           | direction | authorizations          |
      | 1  | Super duper company | Fellowship of the ring | NL23RABO123456789 | GIVEN     | DEBIT_CARD,VIEW,PAYMENT |
    Then the following power of attorney cards should match
      | id | type        |
      | 1  | DEBIT_CARD  |
      | 2  | DEBIT_CARD  |
      | 1  | CREDIT_CARD |

    When retrieving a power of attorney with id 2
    Then the following power of attorney details should match
      | id | grantor             | grantee              | account           | direction | authorizations          |
      | 2  | Super duper company | Super duper employee | NL23RABO987654321 | GIVEN     | DEBIT_CARD,VIEW,PAYMENT |
    Then the following power of attorney cards should match
      | id | type       |
      | 4  | DEBIT_CARD |

  Scenario: Retrieving all power of attorneys
    When retrieving all power of attorneys
    Then the following power of attorneys should be returned
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |


  Scenario: Retrieving a power of attorney should display the correct details
    When retrieving a power of attorney with id 99999
    Then an error should be returned with message containing: Couldn't find POA with id: 99999 and status code: 404

  Scenario: Retrieving a power of attorney with a closed account
    When retrieving a power of attorney with id 4
    Then an error should be returned with message containing: Account has been closed for POA with id: 4 and status code: 400
