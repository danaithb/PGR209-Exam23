CREATE TABLE IF NOT EXISTS machines (
    machine_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);


CREATE TABLE IF NOT EXISTS order_machines (
    order_id BIGINT,
    machine_id BIGINT,
    PRIMARY KEY (order_id, machine_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
    FOREIGN KEY (machine_id) REFERENCES machines(machine_id) ON DELETE CASCADE
);
