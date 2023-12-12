CREATE TABLE part (
                      part_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      part_name VARCHAR(255) NOT NULL,
                      subassembly_id BIGINT,
                      FOREIGN KEY (subassembly_id) REFERENCES subassembly(subassembly_id)
);
