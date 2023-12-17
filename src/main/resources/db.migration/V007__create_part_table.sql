CREATE TABLE IF NOT EXISTS part (
    part_id BIGINT PRIMARY KEY,
    subassembly_id BIGINT,
    part_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (subassembly_id) REFERENCES subassembly(subassembly_id) ON DELETE CASCADE
    );

CREATE SEQUENCE part_seq;
