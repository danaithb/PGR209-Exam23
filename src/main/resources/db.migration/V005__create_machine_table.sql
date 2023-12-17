CREATE TABLE if not exists machine (
    machine_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    machine_name VARCHAR(255) NOT NULL,
    description TEXT
    );


CREATE SEQUENCE machine_seq;


