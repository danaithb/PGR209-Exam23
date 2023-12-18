--inserts example info into table subassembly.
INSERT INTO subassembly (subassembly_name, machine_id, subassembly_id) VALUES
                                                                           ('Flower Bloom Mechanism', 1, 1),
                                                                           ('Stem and Movement System', 1, 2);

-- Restart the sequence for generating subassembly ids with a new starting value of 3,
-- beacuse we inserted 3 subassemblies.
ALTER SEQUENCE subassembly_seq RESTART WITH 3;