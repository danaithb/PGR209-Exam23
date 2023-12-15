CREATE TABLE IF NOT EXISTS subassembly (
    subassembly_id BIGINT PRIMARY KEY,
    machine_id BIGINT,
    subassembly_name VARCHAR(255),
    FOREIGN KEY (machine_id) REFERENCES machine(machine_id) ON DELETE CASCADE
    );

CREATE SEQUENCE subassembly_seq;
