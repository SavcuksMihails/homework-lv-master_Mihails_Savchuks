insert into Client (name,surname,age) values ('Mihails', 'Savcuks', 25)
insert into Client (name,surname,age) values ('Andris', 'Berzins', 26)
insert into Client (name,surname,age) values ('Daniels', 'Dekters', 27)
insert into Client (name,surname,age) values ('Sandis', 'Ozolins', 28)
insert into Client (name,surname,age) values ('Ieva', 'Abolina', 29)


insert into Loan (loantype,description,originalterm, max_possible_amount) values ('Type1', 'Description1', 12, 1000)
insert into Loan (loantype,description,originalterm, max_possible_amount) values ('Type2', 'Description2', 18, 1000)
insert into Loan (loantype,description,originalterm, max_possible_amount) values ('Type3', 'Description3', 24, 1000)
insert into Loan (loantype,description,originalterm, max_possible_amount) values ('Type4', 'Description4', 30, 1000)
insert into Loan (loantype,description,originalterm, max_possible_amount) values ('Type5', 'Description5', 36, 1000)

--insert into Loan_Application (app_id,client_id,loan_id,loan_term,loan_amount,loan_start_date) values (1,1,1,12,100,'2015-12-10 10:07:57')