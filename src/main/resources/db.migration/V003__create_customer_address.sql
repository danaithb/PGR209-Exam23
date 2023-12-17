CREATE TABLE IF NOT EXISTS customer_address (
    customer_id BIGINT,
    address_id BIGINT,
    PRIMARY KEY (customer_id, address_id),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE,
    FOREIGN KEY (address_id) REFERENCES address(address_id) ON DELETE CASCADE
    );

CREATE SEQUENCE customer_address_seq;