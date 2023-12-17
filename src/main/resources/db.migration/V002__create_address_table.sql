CREATE TABLE IF NOT EXISTS address (
                                       address_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                       street VARCHAR(255) NOT NULL,
                                       city VARCHAR(255) NOT NULL,
                                       zip_code VARCHAR(50) NOT NULL,
                                       customer_id BIGINT,
                                       FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE
);

CREATE SEQUENCE address_seq;

