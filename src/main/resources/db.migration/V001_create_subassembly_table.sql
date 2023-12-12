CREATE TABLE IF NOT EXISTS subassembly (
                                           subassembly_id BIGINT NOT NULL PRIMARY KEY,
                                           subassembly_name VARCHAR(255),
                                           subassembly_article_number VARCHAR(255),
                                           machine_id BIGINT,
                                           CONSTRAINT fk_machine_subassembly FOREIGN KEY (machine_id) REFERENCES machines(machine_id) ON DELETE CASCADE
);
