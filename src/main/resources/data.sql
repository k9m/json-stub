-- DEBIT card limits
INSERT INTO limits(id, amount, period_unit) VALUES (1, 3000, 'PER_WEEK')
INSERT INTO limits(id, amount, period_unit) VALUES (2, 50, 'PER_MONTH')
INSERT INTO limits(id, amount, period_unit) VALUES (3, 100, 'PER_DAY')
INSERT INTO limits(id, amount, period_unit) VALUES (4, 10000, 'PER_MONTH')
INSERT INTO limits(id, amount, period_unit) VALUES (5, 10000, 'PER_DAY')
INSERT INTO limits(id, amount, period_unit) VALUES (6, 10000, 'PER_MONTH')
INSERT INTO limits(id, amount, period_unit) VALUES (7, 10000, 'PER_DAY')
INSERT INTO limits(id, amount, period_unit) VALUES (8, 10000, 'PER_MONTH')

-- DEBIT cards
INSERT INTO debit_cards(id, status, card_number, sequence_number, card_holder, atm_limit_id, pos_limit_id, contactless) VALUES (1, 'ACTIVE', 1234, 5, 'Frodo Baggins', 1, 2, true)
INSERT INTO debit_cards(id, status, card_number, sequence_number, card_holder, atm_limit_id, pos_limit_id, contactless) VALUES (2, 'ACTIVE', 6527, 1, 'Aragorn', 3, 4, true)
INSERT INTO debit_cards(id, status, card_number, sequence_number, card_holder, atm_limit_id, pos_limit_id, contactless) VALUES (3, 'BLOCKED', 1111, 32, 'Super duper employee', 5, 6, false)
INSERT INTO debit_cards(id, status, card_number, sequence_number, card_holder, atm_limit_id, pos_limit_id, contactless) VALUES (4, 'ACTIVE', 5678, 5, 'Darth Vader', 7, 8, true)

-- CREDIT cards
INSERT INTO credit_cards(id, status, card_number, sequence_number, card_holder, monthly_limit) VALUES (1, 'ACTIVE', 5075, 1, 'Boromir', 3000)
INSERT INTO credit_cards(id, status, card_number, sequence_number, card_holder, monthly_limit) VALUES (2, 'BLOCKED', 5099, 2, 'Faramir', 4000)

-- ACCOUNTS
INSERT INTO accounts(id, iban, balance, owner, created, ended) VALUES (1, 'NL23RABO123456789', -125.00, 'Super duper employee', '2007-10-12', null)
INSERT INTO accounts(id, iban, balance, owner, created, ended) VALUES (2, 'NL23RABO987654321', 750, 'Super duper company', '2007-10-12', null)
INSERT INTO accounts(id, iban, balance, owner, created, ended) VALUES (3, 'NL23RABO343434343', 6000, 'Super duper company', '2007-10-12', null)
INSERT INTO accounts(id, iban, balance, owner, created, ended) VALUES (4, 'NL23RABO123123123', 0, 'Super duper company', '2007-10-12', '2019-09-01')

--AUTHORIZATIONS
INSERT INTO authorizations(id, auth_value) VALUES (1, 'DEBIT_CARD')
INSERT INTO authorizations(id, auth_value) VALUES (2, 'CREDIT_CARD')
INSERT INTO authorizations(id, auth_value) VALUES (3, 'VIEW')
INSERT INTO authorizations(id, auth_value) VALUES (4, 'PAYMENT')

--POA
INSERT INTO power_of_attorney(id, grantor, grantee, account_id, direction) VALUES (1, 'Super duper company', 'Fellowship of the ring', 1, 'GIVEN')
INSERT INTO power_of_attorney(id, grantor, grantee, account_id, direction) VALUES (2, 'Super duper company', 'Super duper employee', 2, 'GIVEN')
INSERT INTO power_of_attorney(id, grantor, grantee, account_id, direction) VALUES (3, 'Super duper company', 'Super duper employee', 3, 'GIVEN')
INSERT INTO power_of_attorney(id, grantor, grantee, account_id, direction) VALUES (4, 'Super duper employee', 'Super duper company', 4, 'GIVEN')

--POA_AUTH
INSERT INTO auth_poa(poa_id, auth_id) VALUES(1, 1)
INSERT INTO auth_poa(poa_id, auth_id) VALUES(1, 3)
INSERT INTO auth_poa(poa_id, auth_id) VALUES(1, 4)

INSERT INTO auth_poa(poa_id, auth_id) VALUES(2, 1)
INSERT INTO auth_poa(poa_id, auth_id) VALUES(2, 3)
INSERT INTO auth_poa(poa_id, auth_id) VALUES(2, 4)

INSERT INTO auth_poa(poa_id, auth_id) VALUES(3, 3)
INSERT INTO auth_poa(poa_id, auth_id) VALUES(3, 4)

INSERT INTO auth_poa(poa_id, auth_id) VALUES(4, 3)
INSERT INTO auth_poa(poa_id, auth_id) VALUES(4, 4)

--DEBIT_CARDS_POA
INSERT INTO debit_cards_poa(poa_id, dc_id) VALUES(1, 1)
INSERT INTO debit_cards_poa(poa_id, dc_id) VALUES(1, 2)
INSERT INTO debit_cards_poa(poa_id, dc_id) VALUES(2, 3)
INSERT INTO debit_cards_poa(poa_id, dc_id) VALUES(2, 4)

--CREDIT_CARDS_POA
INSERT INTO credit_cards_poa(poa_id, cc_id) VALUES(1, 1)




