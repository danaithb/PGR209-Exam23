CREATE TABLE IF NOT EXISTS addresses (
    address_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    zip_code VARCHAR(50) NOT NULL
);
CREATE SEQUENCE address_seq;

CREATE TABLE IF NOT EXISTS customer_addresses (
   customer_id BIGINT,
   address_id BIGINT,
   PRIMARY KEY (customer_id, address_id),
     FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE,
   FOREIGN KEY (address_id) REFERENCES addresses(address_id) ON DELETE CASCADE
);
CREATE SEQUENCE customer_addresses_seq;