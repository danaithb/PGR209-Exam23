CREATE TABLE subassembly (
                             subassembly_id bigint NOT NULL PRIMARY KEY,
                             subassembly_name varchar(255),
                             subassembly_article_number varchar(255),
                             machine_id bigint,
                             CONSTRAINT fk_machine_subassembly FOREIGN KEY (machine_id) REFERENCES machine(machine_id) ON DELETE CASCADE
);

CREATE SEQUENCE subassembly_seq;
