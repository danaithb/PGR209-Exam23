CREATE TABLE IF NOT EXISTS machine_subassembly (
                                                   machine_id BIGINT,
                                                   subassembly_id BIGINT,
                                                   PRIMARY KEY (machine_id, subassembly_id),
    FOREIGN KEY (machine_id) REFERENCES machine(machine_id) ON DELETE CASCADE,
    FOREIGN KEY (subassembly_id) REFERENCES subassembly(subassembly_id) ON DELETE CASCADE
    );

CREATE SEQUENCE machine_subassembly_seq;