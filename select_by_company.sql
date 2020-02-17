CREATE TABLE company (
	id integer NOT NULL CONSTRAINT company_pkey PRIMARY KEY,
	name character varying
);

INSERT INTO company (id, name) VALUES (1, 'Oracle'); 
INSERT INTO company (id, name) VALUES (2, 'Amazon'); 
INSERT INTO company (id, name) VALUES (3, 'Intel'); 
INSERT INTO company (id, name) VALUES (4, 'Bell'); 
INSERT INTO company (id, name) VALUES (5, 'Sikorskiy'); 

CREATE TABLE person (
	id integer NOT NULL,
	name character varying,
	company_id integer,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO person (id, name, company_id) VALUES (1, 'Tom', 3); 
INSERT INTO person (id, name, company_id) VALUES (2, 'John', 2); 
INSERT INTO person (id, name, company_id) VALUES (3, 'Bill', 1); 
INSERT INTO person (id, name, company_id) VALUES (4, 'Tim', 5);
INSERT INTO person (id, name, company_id) VALUES (5, 'Bob', 4);
INSERT INTO person (id, name, company_id) VALUES (6, 'Sara', 5);

-- names of all persons that are NOT in the company with id = 5
SELECT name
FROM person
WHERE company_id != 5;

--company name for each person
SELECT person.name, company.name
FROM person
JOIN company ON company.id = person.company_id

-- Select the name of the company with the maximum number of persons + number of persons in this company
SELECT company.name, COUNT(person.id)
FROM person
JOIN company ON company.id = person.company_id
WHERE company_id IN (
					SELECT MAX(company_id)
					FROM person)
GROUP BY company.name	
