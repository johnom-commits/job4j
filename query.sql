create database item_db;
CREATE TABLE state (
	state_id serial PRIMARY KEY,
	state varchar(25) 
);
CREATE TABLE category (
	category_id serial PRIMARY KEY,
	category varchar(25)
);
CREATE TABLE rules (
	rules_id serial PRIMARY KEY,
	rules varchar(25)
);
CREATE TABLE role (
	role_id serial PRIMARY KEY,
	role varchar(50) 
);
CREATE TABLE users (
	users_id serial PRIMARY KEY, 
	name_user varchar(50),
	role_id integer,
	FOREIGN KEY (role_id) REFERENCES role (role_id)
);
CREATE TABLE rules_of_role (
	role_id integer, 
	rules_id integer,
	PRIMARY KEY (role_id, rules_id),
	FOREIGN KEY (role_id) REFERENCES role (role_id),
	FOREIGN KEY (rules_id) REFERENCES rules (rules_id)
);
CREATE TABLE item (
	item_id serial PRIMARY KEY,
	user_id integer,
	item_date timestamp,
	category_id integer,
	state_id integer,
	FOREIGN KEY (user_id) REFERENCES users (users_id),
	FOREIGN KEY (category_id) REFERENCES category (category_id),
	FOREIGN KEY (state_id) REFERENCES state (state_id)
);
CREATE TABLE comments (
	comments_id serial PRIMARY KEY,
	comment varchar(500),
	item_id integer,
	FOREIGN KEY (item_id) REFERENCES item (item_id)
);
CREATE TABLE attachs (
	attach_id serial PRIMARY KEY,
	attach bytea,
	item_id integer,
	FOREIGN KEY (item_id) REFERENCES item (item_id)
);
INSERT INTO state (state) VALUES ('Новая');
INSERT INTO state (state) VALUES ('На рассмотрении');
INSERT INTO state (state) VALUES ('Выполняется');
INSERT INTO state (state) VALUES ('Закрыта');
INSERT INTO category (category) VALUES ('Оборудование');
INSERT INTO category (category) VALUES ('ПО');
INSERT INTO category (category) VALUES ('Связь');
INSERT INTO category (category) VALUES ('Котики');
INSERT INTO role (role) VALUES ('Админ');
INSERT INTO role (role) VALUES ('Пользователь');
INSERT INTO users (name_user, role_id) VALUES ('Скумбриевич', '1');
INSERT INTO users (name_user, role_id) VALUES ('Плотский-Поцелуев', '2');
INSERT INTO rules (rules) VALUES ('Чтение');
INSERT INTO rules (rules) VALUES ('Запись');
INSERT INTO rules_of_role (role_id, rules_id) VALUES ('1', '2');
INSERT INTO rules_of_role (role_id, rules_id) VALUES ('2', '1');
INSERT INTO item (user_id, item_date, category_id, state_id) VALUES ('1', '2020-01-20 10:00:00', '1', '3');
INSERT INTO item (user_id, item_date, category_id, state_id) VALUES ('2', '2020-01-22 10:30:00', '2', '4');
INSERT INTO comments (item_id, comment) VALUES ('2', 'Комп не показывает котиков');
INSERT INTO comments (item_id, comment) VALUES ('3', 'Не запускается пасьянс');
INSERT INTO attachs (item_id) VALUES ('2');