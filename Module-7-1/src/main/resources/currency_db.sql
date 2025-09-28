-- 1. Drop the old database if it exists
DROP DATABASE IF EXISTS currency_db;

-- 2. Create the new database
CREATE DATABASE currency_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

-- 3. Use the database
USE currency_db;

--3. Create a table for Currency objects
CREATE TABLE Currency (
                          abbreviation CHAR(3) PRIMARY KEY,
                          name VARCHAR(50) NOT NULL,
                          rate_to_usd DECIMAL(10,6) NOT NULL
);

-- 4. Populate the table with 8 different currencies
INSERT INTO Currency (abbreviation, name, rate_to_usd) VALUES
                                                           ('USD', 'United States Dollar', 1.000000),
                                                           ('EUR', 'Euro', 1.090000),
                                                           ('GBP', 'British Pound', 1.270000),
                                                           ('JPY', 'Japanese Yen', 0.006700),
                                                           ('CHF', 'Swiss Franc', 1.110000),
                                                           ('AUD', 'Australian Dollar', 0.660000),
                                                           ('CAD', 'Canadian Dollar', 0.730000),
                                                           ('INR', 'Indian Rupee', 0.012000);

-- 5. Drop user appuser if it exists
Drop USER IF EXISTS 'appuser'@'localhost';

-- 6. Create user appuser
CREATE USER 'appuser'@'localhost' IDENTIFIED  By 'app_pass123'

-- 7. Grant only the needed privileges (SELECT, INSERT, UPDATE for app use)
GRANT SELECT, INSERT, UPDATE on currency_db. * TO 'appuser'@'localhost';

-- Apply privileges
FLUSH PRIVILEGES;
