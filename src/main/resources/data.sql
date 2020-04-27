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
INSERT INTO debit_cards(id, status, card_number, sequence_number, card_holder, atm_limit_id, pos_limit_id, contactless) VALUES (3, 'ACTIVE', 1111, 32, 'Super duper employee', 5, 6, false)
INSERT INTO debit_cards(id, status, card_number, sequence_number, card_holder, atm_limit_id, pos_limit_id, contactless) VALUES (4, 'BLOCKED', 5678, 5, 'Darth Vader', 7, 8, true)

-- CREDIT cards
INSERT INTO credit_cards(id, status, card_number, sequence_number, card_holder, monthly_limit) VALUES (1, 'ACTIVE', 5075, 1, 'Boromir', 3000)
INSERT INTO credit_cards(id, status, card_number, sequence_number, card_holder, monthly_limit) VALUES (2, 'BLOCKED', 5099, 2, 'Faramir', 4000)


