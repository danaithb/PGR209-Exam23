CREATE TABLE IF NOT EXISTS addresses (
                                         address_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         street VARCHAR(255),
                                         city VARCHAR(255),
                                         zip_code VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS customer_addresses (
                                                  customer_id BIGINT,
                                                  address_id BIGINT,
                                                  PRIMARY KEY (customer_id, address_id),
                                                  FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE,
                                                  FOREIGN KEY (address_id) REFERENCES addresses(address_id) ON DELETE CASCADE
);
