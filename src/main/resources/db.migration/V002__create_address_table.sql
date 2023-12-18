--Creates table address. Uses address_seq to generate a unique value for addressId.
CREATE TABLE IF NOT EXISTS address (
    address_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    zip_code VARCHAR(50) NOT NULL
);
CREATE SEQUENCE address_seq;

