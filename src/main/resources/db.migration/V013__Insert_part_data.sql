--inserts example info into table part.
INSERT INTO part (part_name, subassembly_id, part_id) VALUES
                                                          ('Petals with LED lights', 1, 1),
                                                          ('Central Gear System', 1, 2),
                                                          ('Micro-motors', 1, 3);

INSERT INTO part (part_name, subassembly_id, part_id) VALUES
                                                          ('Articulated Stem', 2, 4),
                                                          ('Base Motor', 2, 5),
                                                          ('Proximity Sensors', 2, 6);

-- Restarts the sequence for generating subassembly ids with a new starting value of 6,
-- because we inserted 6 parts.
ALTER SEQUENCE subassembly_seq RESTART WITH 6;