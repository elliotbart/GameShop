CREATE TABLE CART (
	pk_id INT,
	price INT,
	PRIMARY KEY (pk_id)
);

CREATE TABLE GAME (
	pk_title VARCHAR(40),
	price INT,
	PRIMARY KEY (pk_title)
);

CREATE TABLE CONSOLE (
	pk_name VARCHAR(20),
	PRIMARY KEY (pk_name)
);

CREATE TABLE TYPE (
	pk_type VARCHAR(20),
	PRIMARY KEY (pk_type)
);

CREATE TABLE CLIENT (
	pk_email VARCHAR(40),
	lastName VARCHAR(20) NOT NULL,
	firstName VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	birthDate DATE NOT NULL,
	fk_cart INT,
	FOREIGN KEY (fk_cart) REFERENCES CART(pk_id),
	PRIMARY KEY (pk_email)
);

CREATE TABLE GAME_TYPE (
	fk_game VARCHAR(40),
	fk_type VARCHAR(20),
	FOREIGN KEY (fk_type) REFERENCES TYPE(pk_type),
	FOREIGN KEY (fk_game) REFERENCES GAME(pk_title),
	PRIMARY KEY (fk_game, fk_type)
);

CREATE TABLE CART_GAME (
	fk_cart INT,
	fk_game VARCHAR(40),
	nb SMALLINT,
	PRIMARY KEY (fk_cart, fk_game),
	FOREIGN KEY (fk_cart) REFERENCES CART(pk_id),
	FOREIGN KEY (fk_game) REFERENCES GAME(pk_title)
);

CREATE TABLE CONSOLE_GAME (
	fk_console VARCHAR(20),
	fk_game VARCHAR(40),
	FOREIGN KEY (fk_console) REFERENCES CONSOLE(pk_name),
	FOREIGN KEY (fk_game) REFERENCES GAME(pk_title),
	PRIMARY KEY (fk_console, fk_game)
);
