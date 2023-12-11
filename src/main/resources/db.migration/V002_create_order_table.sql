CREATE TABLE IF NOT EXISTS orders (
                                      order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      customer_id BIGINT NOT NULL,
                                      order_date TIMESTAMP NOT NULL,
                                      FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);
