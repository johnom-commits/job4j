CREATE TABLE body (
	vin 	   varchar(17) NOT NULL PRIMARY KEY,
	type 	   varchar(15) NOT NULL,
	numberDoor int         NOT NULL,
	color  	   varchar(20) NOT NULL
);

CREATE TABLE engine (
	id 				serial 		 NOT NULL PRIMARY KEY,
	volume 			numeric(6,2) NOT NULL,
	power 		    int 		 NOT NULL,
	numberCylinders int  		 NOT NULL
);

CREATE TABLE transmission (
	id 			serial 		NOT NULL PRIMARY KEY,
	type 		varchar(15) NOT NULL,
	numberGears int 		NOT NULL
);

CREATE TABLE cars (
	id 				serial 		NOT NULL PRIMARY KEY,
	brand 			varchar(15) NOT NULL,
	model 			varchar(15) NOT NULL,
	id_body 		varchar(17) REFERENCES body(vin),
	id_engine 		int 		REFERENCES engine(id),
	id_transmission int 		REFERENCES transmission(id)
);

INSERT INTO body (vin, type, numberDoor, color) VALUES ('1232357435FDSAKHL', 'седан', 4, 'серый');
INSERT INTO body (vin, type, numberDoor, color) VALUES ('1232350435FDSAKHO', 'хечбек', 3, 'белый');
INSERT INTO body (vin, type, numberDoor, color) VALUES ('1232357435FDSAWER', 'хечбек', 5, 'красный');
INSERT INTO body (vin, type, numberDoor, color) VALUES ('1232357435FDSAXGZ', 'фаэтон', 4, 'черный');

INSERT INTO engine (volume, power, numberCylinders) VALUES (1.6, 106, 4);
INSERT INTO engine (volume, power, numberCylinders) VALUES (2.6, 80, 6);
INSERT INTO engine (volume, power, numberCylinders) VALUES (0.65, 35, 2);
INSERT INTO engine (volume, power, numberCylinders) VALUES (4.0, 300, 8);

INSERT INTO transmission (type, numberGears) VALUES ('механическая', 4);
INSERT INTO transmission (type, numberGears) VALUES ('механическая', 5);
INSERT INTO transmission (type, numberGears) VALUES ('механическая', 3);
INSERT INTO transmission (type, numberGears) VALUES ('автоматическая', 6);

INSERT INTO cars (brand, model, id_body, id_engine, id_transmission) VALUES ('ВАЗ', 'Ока', '1232350435FDSAKHO', 3, 1);
INSERT INTO cars (brand, model, id_body, id_engine, id_transmission) VALUES ('ВАЗ', 'Калина', '1232357435FDSAWER', 1, 2);
INSERT INTO cars (brand, model, id_body, id_engine, id_transmission) VALUES ('Лорен Дитрих', 'Антилопа Гну', '1232357435FDSAXGZ', 2, 3);

SELECT brand, model, body.vin, body.color, body.type, body.numberDoor, engine.volume, engine.power, engine.numberCylinders, trans.type, trans.numberGears 
FROM cars
JOIN body ON cars.id_body = body.vin
JOIN engine ON cars.id_engine = engine.id
JOIN transmission AS trans ON cars.id_transmission = trans.id;

SELECT body.vin, engine.volume, t.id
FROM cars
FULL OUTER JOIN body ON cars.id_body = body.vin
FULL OUTER JOIN engine ON cars.id_engine = engine.id
FULL OUTER JOIN transmission AS t ON cars.id_transmission = t.id
WHERE model IS NULL;