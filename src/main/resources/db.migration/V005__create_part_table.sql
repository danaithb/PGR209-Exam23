CREATE TABLE if not exists part (
    part_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    part_name VARCHAR(255) NOT NULL
    );

CREATE SEQUENCE part_seq;