CREATE TABLE machines (
                          machine_id bigint NOT NULL auto_increment PRIMARY KEY,
                          order_id bigint NOT NULL,
                          machine_name varchar(255) NOT NULL,
                          description text,
                          CONSTRAINT fk_order_machine FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE
);

CREATE SEQUENCE machine_seq START WITH 1 INCREMENT BY 1;
