--Inserts example info into table customer.
INSERT INTO customer (customer_name, customer_email) VALUES ('Anna Smith', 'anna@example.com');
INSERT INTO customer (customer_name, customer_email) VALUES ('John Doe', 'john.doe@example.com');

ALTER SEQUENCE customer_seq RESTART WITH 3;