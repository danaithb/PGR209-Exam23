--Creates table orders. Uses orders_seq to generate a unique value for orderId.
CREATE TABLE IF NOT EXISTS orders (
    order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    machine_id BIGINT NOT NULL,
    order_date TIMESTAMP NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (machine_id) REFERENCES machine(machine_id) ON DELETE CASCADE
    );

CREATE SEQUENCE orders_seq;

