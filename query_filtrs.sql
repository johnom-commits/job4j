--1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT name 
FROM product 
WHERE type_id = (SELECT id FROM type WHERE name = 'СЫР');

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT name 
FROM product 
WHERE name LIKE '%мороженное%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT name 
FROM product 
WHERE date_part('month', expired_date) = date_part('month', now()) + 1;

--4. Написать запрос, который выводит самый дорогой продукт.
SELECT name, price 
FROM Product 
WHERE price = (SELECT MAX(price) FROM Product);

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT COUNT(*)
FROM Product
WHERE type_id = '1';

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT name
FROM Product
WHERE type_id IN (
	SELECT id 
	FROM type 
	WHERE name IN ('СЫР', 'МОЛОКО')
);

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
SELECT type, count
FROM
	(SELECT Type.name AS type, COUNT(*) AS count
	FROM Product 
	JOIN Type ON Product.type_id = Type.id
	GROUP BY Type.name) AS harchi 
WHERE count < 10;

--8. Вывести все продукты и их тип.
SELECT Type.name AS type, Product.name
FROM Product 
JOIN Type ON Product.type_id = Type.id
