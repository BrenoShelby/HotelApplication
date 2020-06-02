DROP DATABASE IF EXISTS hotel;
CREATE DATABASE hotel;

USE hotel;

/*CRIE AS TABELAS*/
CREATE TABLE hospede
(
	cpf BIGINT(5),
    nome VARCHAR(30) NOT NULL,
    rg BIGINT(5) UNIQUE NULL,
    email VARCHAR(50) NULL,
    data_nascimento DATE NOT NULL,
    telefone_residencial BIGINT(5) NULL,
    telefone_celular BIGINT(5) NULL,
    
    PRIMARY KEY(cpf)
);

CREATE TABLE endereco
(
	cpf BIGINT(5),
    numero INT NULL,
    complemento VARCHAR(30) NULL,
    rua VARCHAR(50) NOT NULL,
    cidade VARCHAR (20) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    pais VARCHAR(20) NOT NULL,
    
    FOREIGN KEY(cpf) REFERENCES hospede(cpf) ON DELETE CASCADE
);

CREATE TABLE quarto
(
	id_quarto INT AUTO_INCREMENT,
    tipo_quarto VARCHAR(15),
    qtd_adultos INT,
    qtd_criancas INT,
    valor DECIMAL(6,2),
    
    PRIMARY KEY(id_quarto)
) AUTO_INCREMENT = 100;

CREATE TABLE reserva_quarto
(
	id_reserva INT AUTO_INCREMENT,
    cpf BIGINT(5),
    id_quarto INT UNIQUE,
    data_entrada DATE NOT NULL,
    
    data_saida DATE NOT NULL,
    
    PRIMARY KEY(id_reserva),
    FOREIGN KEY(cpf) REFERENCES hospede(cpf) ON DELETE CASCADE,
    FOREIGN KEY(id_quarto) REFERENCES quarto(id_quarto)
);

CREATE TABLE servico
(
	nome VARCHAR(50),
    preco DECIMAL(5,2),
    
    PRIMARY KEY(nome)
);

SELECT * FROM quarto;

SELECT * FROM hospede;

SELECT * FROM endereco;

SELECT * FROM reserva_quarto;

SELECT * FROM servico;

DROP TABLE endereco, reserva_quarto, hospede;

/*INSIRA TODOS ESSES QUARTOS (OBRIGATORIAMENTE)*/
INSERT INTO quarto
VALUES  (1, 'Standard', 2, 2, 200.50),
        (2, 'Standard', 2, 1, 200.50),
	(3, 'Standard', 2, 0, 200.50),
	(4, 'Standard', 4, 0, 200.50),
	(5, 'Standard', 3, 1, 200.50),
	(6, 'Standard', 2, 2, 200.50),
	(7, 'Standard', 1, 2, 200.50),
	(8, 'Standard', 3, 0, 200.50),
	(9, 'Standard', 2, 0, 200.50),
	(10, 'Standard', 2, 1, 200.50);
	
INSERT INTO quarto 
VALUES  (11, 'Suite', 3, 1, 980.00),
	(12, 'Suite', 2, 0, 980.00),
	(13, 'Suite', 2, 3, 980.00),
	(14, 'Suite', 2, 2, 980.00),
	(15, 'Suite', 4, 0, 980.00),
	(16, 'Suite', 3, 2, 980.00),
	(17, 'Suite', 1, 2, 980.00),
	(18, 'Suite', 2, 1, 980.00),
	(19, 'Suite', 2, 3, 980.00),
	(20, 'Suite', 2, 3, 980.00);

INSERT INTO quarto
VALUES  (21, 'Luxo', 2, 1, 1420.00),
	(22, 'Luxo', 4, 0, 1420.00),
	(23, 'Luxo', 2, 2, 1420.00),
	(24, 'Luxo', 3, 2, 1420.00),
	(25, 'Luxo', 3, 1, 1420.00),
	(26, 'Luxo', 3, 3, 1420.00),
	(27, 'Luxo', 4, 2, 1420.00),
	(28, 'Luxo', 3, 0, 1420.00),
	(29, 'Luxo', 2, 4, 1420.00),
	(30, 'Luxo', 4, 2, 1420.00);

/*INSIRA TODOS ESSES SERVIÇOS (OBRIGATORIAMENTE)*/
INSERT INTO servico (nome, preco) 
VALUES ('Café da manhã', 50.00),
		('Café da manhã e Almoço', 100.00),
	   ('Café da manhã e Jantar', 120.00),
		('Todas as refeições', 180.00),
        ('Wi-Fi', 15.00),
		('Aceita animais', 60.00),
		('Estacionamento', 80.00),
		('SPA', 130.00),
		('Piscina', 45.00),
		('TV por assinatura', 50.00),
  		('Computador', 140.00),
		('Cerveja', 16.00),
		('Champagne', 550.00),
		('Whisky', 950.00),
		('vodka', 250.00); 