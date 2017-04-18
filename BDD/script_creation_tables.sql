# Creation des tables, insertions



-- Cart

CREATE TABLE CART (
	pk_id INT AUTO_INCREMENT PRIMARY KEY
);



-- Console

CREATE TABLE CONSOLE (
	pk_name VARCHAR(255) PRIMARY KEY
);

INSERT INTO CONSOLE(pk_name) VALUES("PS3");
INSERT INTO CONSOLE(pk_name) VALUES("PS4");
INSERT INTO CONSOLE(pk_name) VALUES("PC");
INSERT INTO CONSOLE(pk_name) VALUES("XBOX 360");



-- Game

CREATE TABLE GAME (
	pk_title VARCHAR(255) PRIMARY KEY,
	fk_console VARCHAR(255) NOT NULL,
	price DOUBLE NOT NULL,
	FOREIGN KEY (fk_console) REFERENCES CONSOLE(pk_name)
);

INSERT INTO GAME(pk_title, fk_console, price) VALUES("FIFA 17", "PS4", "59.99");
INSERT INTO GAME(pk_title, fk_console, price) VALUES("FIFA 16", "PS3", "29.99");
INSERT INTO GAME(pk_title, fk_console, price) VALUES("NBA 2K17", "XBOX 360", "39.99");



-- Type

CREATE TABLE TYPE (
	pk_type VARCHAR(255) PRIMARY KEY
);

INSERT INTO TYPE(pk_type) VALUES ("Sport");



-- Client

CREATE TABLE CLIENT (
	pk_email VARCHAR(255) PRIMARY KEY,
	lastName VARCHAR(255) NOT NULL,
	firstName VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	birthDate DATE NOT NULL,
	fk_cart INT NOT NULL,
	FOREIGN KEY (fk_cart) REFERENCES CART(pk_id)
);

INSERT INTO CART() VALUES();
insert INTO CLIENT(pk_email, lastName, firstName, password, birthDate, fk_cart) VALUES("virgilew@gmail.com", "Vancon", "Virgile", "pwd", "1996-04-01", 1);
INSERT INTO CART() VALUES();
insert INTO CLIENT(pk_email, lastName, firstName, password, birthDate, fk_cart) VALUES("pbathell@etu.utc.fr", "Bathellier", "Pierre", "pwd", "1995-10-12", 2);
INSERT INTO CART() VALUES();
insert INTO CLIENT(pk_email, lastName, firstName, password, birthDate, fk_cart) VALUES("ebarthol@etu.utc.fr", "Okkis", "Elliot", "pwd", "1995-03-18", 3);



-- Game_Type association

CREATE TABLE GAME_TYPE (
	fk_game VARCHAR(255),
	fk_type VARCHAR(255),
	FOREIGN KEY (fk_type) REFERENCES TYPE(pk_type),
	FOREIGN KEY (fk_game) REFERENCES GAME(pk_title),
	PRIMARY KEY (fk_game, fk_type)
);

INSERT INTO GAME_TYPE(fk_game, fk_type) VALUES("FIFA 17", "Sport");
INSERT INTO GAME_TYPE(fk_game, fk_type) VALUES("NBA 2K17", "Sport");



-- Ligne_Cart

CREATE TABLE LIGNE_CART (
	fk_cart INT,
	fk_game VARCHAR(255),
	quantity INT NOT NULL,
	FOREIGN KEY (fk_cart) REFERENCES CART(pk_id),
	FOREIGN KEY (fk_game) REFERENCES GAME(pk_title),
	PRIMARY KEY (fk_cart, fk_game)
);

