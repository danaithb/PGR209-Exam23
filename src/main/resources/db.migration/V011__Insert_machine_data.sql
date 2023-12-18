--Inserts example info into table machine.
INSERT INTO machine (machine_name, description) VALUES
    ('Interactive Robotic Flower Garden', 'A robotic garden with flower mechanisms');

-- Restart the sequence for generating machine ids with a new starting value of 2,
--because we inserted 2 machines.
ALTER SEQUENCE machine_seq RESTART WITH 2;
