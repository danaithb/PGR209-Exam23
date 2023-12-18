--Creates table customer. Uses customer_seq to generate a unique value for customerId.
CREATE TABLE IF NOT EXISTS customer (
  customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  customer_name VARCHAR(255) NOT NULL,
  customer_email VARCHAR(255) NOT NULL
);
CREATE SEQUENCE customer_seq;
