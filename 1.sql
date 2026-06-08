DROP TABLE IF EXISTS cabinet;
CREATE TABLE "cabinet" ("id" INTEGER UNIQUE, "title" VARCHAR, "room" NUMERIC, "housing" INTEGER, PRIMARY KEY ("id"), FOREIGN KEY ("housing") REFERENCES "housing" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION);

-- Таблица: equipment
DROP TABLE IF EXISTS equipment;
CREATE TABLE "equipment" ("id" INTEGER UNIQUE, "title" VARCHAR, "type" INTEGER, "number" VARCHAR, "cost" NUMERIC, "date" DATE, PRIMARY KEY ("id"), FOREIGN KEY ("type") REFERENCES "type" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION);

-- Таблица: housing
DROP TABLE IF EXISTS housing;
CREATE TABLE "housing" ("id" INTEGER UNIQUE, "title" VARCHAR, "organization" INTEGER, PRIMARY KEY ("id"), FOREIGN KEY ("organization") REFERENCES "organization" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION);

-- Таблица: inventory_number
DROP TABLE IF EXISTS inventory_number;
CREATE TABLE "inventory_number" ("id" INTEGER UNIQUE, "title" VARCHAR,  PRIMARY KEY ("id"));

-- Таблица: inventory
DROP TABLE IF EXISTS inventory;
CREATE TABLE "inventory" ("id" INTEGER UNIQUE, "equipment" INTEGER, "cabinet" INTEGER, "staff" INTEGER, "data" VARCHAR, PRIMARY KEY ("id"), FOREIGN KEY ("staff") REFERENCES staff ("id") ON UPDATE NO ACTION ON DELETE NO ACTION, FOREIGN KEY ("equipment") REFERENCES equipment ("id") ON UPDATE NO ACTION ON DELETE NO ACTION, FOREIGN KEY ("cabinet") REFERENCES cabinet ("id") ON DELETE NO ACTION ON UPDATE NO ACTION, FOREIGN KEY ("inventory_number") REFERENCES inventory_number ("id") ON DELETE NO ACTION ON UPDATE NO ACTION);

-- Таблица: organization
DROP TABLE IF EXISTS organization;
CREATE TABLE "organization" ( "id" INTEGER UNIQUE, "title" VARCHAR, "addr" VARCHAR, PRIMARY KEY("id"),FOREIGN KEY ("id") REFERENCES "housing"("organization")ON UPDATE NO ACTION ON DELETE NO ACTION);

-- Таблица: post
DROP TABLE IF EXISTS post;
CREATE TABLE "post" ("id" INTEGER UNIQUE, "title" VARCHAR, PRIMARY KEY ("id"));

-- Таблица: staff
DROP TABLE IF EXISTS staff;
CREATE TABLE "staff" ("id" INTEGER UNIQUE, "name" VARCHAR,"post" INTEGER, PRIMARY KEY ("id"), FOREIGN KEY ("post") REFERENCES "post" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION);

-- Таблица: type
DROP TABLE IF EXISTS type;
CREATE TABLE "type" ("id" INTEGER UNIQUE, "title" VARCHAR, PRIMARY KEY ("id"));