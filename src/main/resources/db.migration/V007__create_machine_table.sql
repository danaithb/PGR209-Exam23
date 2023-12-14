create table if not exists machine (
    machine_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    machine_name VARCHAR(255) NOT NULL,
    description TEXT,
    subassembly_id BIGINT,
    FOREIGN KEY (subassembly_id) REFERENCES subassembly(subassembly_id) ON DELETE CASCADE
    );

CREATE SEQUENCE machine_seq;


