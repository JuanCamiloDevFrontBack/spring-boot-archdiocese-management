-- Nota: este archivo en una aplicación de uso empresarial por ningún
-- motivo debe publicarse, aquí se comparte porque es un proyecto académico.

-- Step 1: Create the Database
CREATE DATABASE Archdiocese;

-- Step 2: Create Users, esto solo se ejecuto en local, pero se deja en el script.
CREATE USER admin WITH PASSWORD '12345678';
CREATE USER dev WITH PASSWORD '87654321';

-- Step 3: Grant Permissions
GRANT CONNECT ON DATABASE Archdiocese TO admin;
GRANT CONNECT ON DATABASE Archdiocese TO dev;

-- Connect to the new database
\c Archdiocese

-- Grant permissions to admin
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO admin;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO admin;

-- Grant permissions to dev
GRANT SELECT, INSERT ON ALL TABLES IN SCHEMA public TO dev;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT ON TABLES TO dev;

-- Step 4: Create Tables
-- Faltaria campo de imagen
CREATE TABLE parish (
    id SERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    address VARCHAR(70) NOT NULL,
    district VARCHAR(55)
);

INSERT INTO parish (id, name, address, district) values
(890, 'St. Patrick', '123 Main St', 'Downtown'),
(891, 'St. Joseph', '456 Elm St', 'Westside'),
(892, 'St. Mary', '789 Oak St', 'Eastside');


-- Faltaria campo de imagen
CREATE TABLE priest (
    id SERIAL PRIMARY KEY,
    name VARCHAR(37) NOT NULL,
    age INT NOT NULL,
    ordination_date DATE NOT NULL,
    is_parish_priest CHAR(1) NOT NULL,
    id_parish INT,
    CONSTRAINT fk_parish
        FOREIGN KEY(id_parish) 
        REFERENCES parish(id)
);

INSERT INTO priest (name, age, ordination_date, is_parish_priest, id_parish) values
('Fr. John Smith', 45, '2001-05-15', 'S', 890),
('Fr. Michael Johnson', 50, '1995-08-20', 'N', 891),
('Fr. Peter Williams', 38, '2010-03-25', 'S', 892),
('Fr. Andrew Davis', 60, '1980-10-10', 'N', NULL);

-- Querys
SELECT * FROM priest;
SELECT * FROM parish;

DELETE FROM priest;
DELETE FROM parish;

SELECT * FROM priest
WHERE is_parish_priest = 'S'
ORDER BY age DESC
LIMIT 1;

SELECT p.name AS priest_name, pr.name AS parish_name
FROM priest p
LEFT JOIN parish pr ON p.id_parish = pr.id;

SELECT pr.name AS parish_name, COUNT(p.id) AS number_of_priests
FROM priest p
LEFT JOIN parish pr ON p.id_parish = pr.id
GROUP BY pr.name;