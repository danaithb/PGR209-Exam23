CREATE TABLE IF NOT EXISTS subassembly (
    subassembly_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    subassembly_name VARCHAR(255),
    part_id BIGINT,
    FOREIGN KEY (part_id) REFERENCES part(part_id) ON DELETE CASCADE
    );

CREATE SEQUENCE subassembly_seq;