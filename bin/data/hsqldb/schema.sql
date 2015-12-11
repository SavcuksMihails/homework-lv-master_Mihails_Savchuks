DROP TABLE Client IF EXISTS;
DROP TABLE Loan IF EXISTS;
DROP TABLE Client_loan_applications IF EXISTS;
DROP SEQUENCE APP_ID_SEQUENCE IF EXISTS;

CREATE TABLE Client 
(
id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL,
name VARCHAR(100) NOT NULL,
surname VARCHAR(100) NOT NULL,
age INT NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE Loan 
(
id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL,
loantype VARCHAR(100) NOT NULL,
description VARCHAR(100) NOT NULL,
originalterm INT NOT NULL,
max_possible_amount INT NOT NULL,
PRIMARY KEY(id)
);

CREATE SEQUENCE IF NOT EXISTS APP_ID_SEQUENCE;
CREATE TABLE Client_loan_applications
(
app_id BIGINT NOT NULL,
client_id BIGINT NOT NULL,
loan_id BIGINT NOT NULL,
loan_term INT NOT NULL,
loan_amount INT NOT NULL,
loan_start_date TIMESTAMP,
ip VARCHAR(100) NOT NULL,
);