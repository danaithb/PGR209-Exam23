CREATE TABLE IF NOT EXISTS machines (
    machine_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    FOREIGN KEY (order_id) REFERENCES order(order_id) ON DELETE SET NULL
);
