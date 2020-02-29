-- 1. Есть таблица встреч(id, name), есть таблица юзеров(id, name).
-- Нужно доработать модель базы данных, так чтобы пользователи могли учавствовать во встречах. 
-- У каждого участника встречи может быть разный статус участия - например подтвердил участие, отклонил.

CREATE TABLE meetings (
	id serial PRIMARY KEY,
	name varchar(50)
);

CREATE TABLE users (
	id serial PRIMARY KEY,
	name varchar(50)
);

CREATE TABLE status (
	id serial PRIMARY KEY,
	name varchar(20)
);

CREATE TABLE applications (
	id serial PRIMARY KEY,
	id_meeting integer,
	id_user integer,
	id_status integer
);

INSERT INTO meetings (name) VALUES ('Собрание на ликеро-водочном заводе');
INSERT INTO meetings (name) VALUES ('Встреча участников автопробега');
INSERT INTO meetings (name) VALUES ('Заседание клуба Ход конем');
INSERT INTO meetings (name) VALUES ('Субботник');

INSERT INTO users (name) VALUES ('Плотский-Поцелуев');
INSERT INTO users (name) VALUES ('Скумбриевич');
INSERT INTO users (name) VALUES ('Бендер Остап Ибрагимович');
INSERT INTO users (name) VALUES ('Ляпис Трубецкой');
INSERT INTO users (name) VALUES ('Паниковский');

INSERT INTO status (name) VALUES ('Подтвердил');
INSERT INTO status (name) VALUES ('Отклонил');
INSERT INTO status (name) VALUES ('Не ответил');

INSERT INTO applications (id_meeting, id_user, id_status) VALUES (1, 1, 1);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (1, 2, 1);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (1, 3, 1);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (1, 4, 1);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (1, 5, 1);

INSERT INTO applications (id_meeting, id_user, id_status) VALUES (2, 1, 3);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (2, 2, 1);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (2, 3, 1);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (2, 4, 2);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (2, 5, 1);

INSERT INTO applications (id_meeting, id_user, id_status) VALUES (3, 1, 1);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (3, 2, 3);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (3, 3, 2);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (3, 4, 2);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (3, 5, 1);

INSERT INTO applications (id_meeting, id_user, id_status) VALUES (4, 1, 2);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (4, 2, 3);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (4, 3, 2);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (4, 4, 2);
INSERT INTO applications (id_meeting, id_user, id_status) VALUES (4, 5, 3);

-- 2. Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников.

SELECT meetings.name, COUNT(id_meeting)
FROM applications
JOIN meetings ON meetings.id = applications.id_meeting
WHERE id_status = 1
GROUP BY meetings.name;

-- 3. Нужно получить все совещания, где не было ни одной заявки на посещения

SELECT meetings.name
FROM
(SELECT id
FROM meetings
EXCEPT
SELECT id_meeting
FROM applications
WHERE id_status = 1
GROUP BY id_meeting) AS result
JOIN meetings ON result.id = meetings.id

