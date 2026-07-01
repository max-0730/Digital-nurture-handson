USE ormlearn;
SELECT * FROM country;

SELECT COUNT(*) FROM country;
INSERT INTO country (co_code, co_name)
VALUES
('IN', 'India'),
('US', 'United States of America');
SELECT * FROM country;

USE ormlearn;

SELECT * FROM country WHERE co_code='NP';