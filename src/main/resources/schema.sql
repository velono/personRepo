DROP TABLE IF EXISTS address CASCADE;
DROP TABLE IF EXISTS person CASCADE;
DROP TABLE IF EXISTS contact CASCADE;

CREATE TABLE IF NOT EXISTS address (
	id SERIAL PRIMARY KEY,
	city varchar(255) NOT NULL, 
	street_name varchar(255) ,
	street_type varchar(255),
	number int,
	permanent boolean,
	personid int
);

CREATE TABLE IF NOT EXISTS contact(
	id SERIAL PRIMARY KEY,
	email VARCHAR(255) NOT NULL,
	tel int NOT NULL
);
CREATE TABLE IF NOT EXISTS person (
	id SERIAL PRIMARY KEY, 
	lastname varchar(255) NOT NULL,
	firstname varchar(255) NOT NULL,
	contactid int REFERENCES contact
);