--
-- Файл сгенерирован с помощью SQLiteStudio v3.4.17 в Сб ноя 29 10:15:08 2025
--
-- Использованная кодировка текста: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Таблица: cabinet
DROP TABLE IF EXISTS cabinet;
CREATE TABLE IF NOT EXISTS cabinet (id INTEGER UNIQUE, title VARCHAR UNIQUE, room NUMERIC, housing INTEGER, PRIMARY KEY (id AUTOINCREMENT), FOREIGN KEY (housing) REFERENCES housing (id) ON DELETE NO ACTION ON UPDATE NO ACTION);

-- Таблица: equipment
DROP TABLE IF EXISTS equipment;
CREATE TABLE IF NOT EXISTS equipment (id INTEGER UNIQUE, title VARCHAR, number VARCHAR UNIQUE, cost NUMERIC, date DATE, PRIMARY KEY (id AUTOINCREMENT));

-- Таблица: housing
DROP TABLE IF EXISTS housing;
CREATE TABLE IF NOT EXISTS housing (id INTEGER UNIQUE, title VARCHAR, organization INTEGER, PRIMARY KEY (id), FOREIGN KEY (organization) REFERENCES organization (id) ON DELETE NO ACTION ON UPDATE NO ACTION MATCH SIMPLE);

-- Таблица: inventory
DROP TABLE IF EXISTS inventory;
CREATE TABLE IF NOT EXISTS inventory (id INTEGER UNIQUE, equipment INTEGER, cabinet INTEGER, staff INTEGER, data VARCHAR, PRIMARY KEY (id AUTOINCREMENT), FOREIGN KEY (staff) REFERENCES staff (id) ON UPDATE NO ACTION ON DELETE NO ACTION, FOREIGN KEY (equipment) REFERENCES equipment (id) ON UPDATE NO ACTION ON DELETE NO ACTION, FOREIGN KEY (cabinet) REFERENCES cabinet (id) ON DELETE NO ACTION ON UPDATE NO ACTION);

-- Таблица: organization
DROP TABLE IF EXISTS organization;
CREATE TABLE IF NOT EXISTS "organization" (
	"id" INTEGER UNIQUE,
	"title" VARCHAR,
	"addr" VARCHAR,
	PRIMARY KEY("id"),
	FOREIGN KEY ("id") REFERENCES "housing"("organization")
	ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Таблица: post
DROP TABLE IF EXISTS post;
CREATE TABLE IF NOT EXISTS post (id INTEGER UNIQUE, title VARCHAR, PRIMARY KEY (id AUTOINCREMENT));
INSERT INTO post (id, title) VALUES (1, 'Завхоз');
INSERT INTO post (id, title) VALUES (2, 'Завхоз');

-- Таблица: staff
DROP TABLE IF EXISTS staff;
CREATE TABLE IF NOT EXISTS staff (id INTEGER UNIQUE, name VARCHAR, post INTEGER, PRIMARY KEY (id AUTOINCREMENT), FOREIGN KEY (post) REFERENCES post (id) ON DELETE NO ACTION ON UPDATE NO ACTION);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
