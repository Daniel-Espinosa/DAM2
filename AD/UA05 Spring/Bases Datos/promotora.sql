create database promotora;
use promotora;

CREATE TABLE festival (
    pkfestival INT(11) PRIMARY KEY,
    nombre VARCHAR(80),
    anyo DATE,
    num_personas INT(11)
);

CREATE TABLE escenario (
    pkescenario INT(11) PRIMARY KEY,
    nombre VARCHAR(80),
    afestival INT(11),
    aforo INT(11),
    FOREIGN KEY (afestival) REFERENCES festival(pkfestival)
);

CREATE TABLE grupo (
	pkgrupo INT (11) PRIMARY KEY, 
	nombre VARCHAR (80), 
	estilo VARCHAR (80)
);

CREATE TABLE concierto (
    pkconcierto INT(11) PRIMARY KEY,
    akgrupo INT(11),
    akescenario INT(11),
    fecha DATE,
	pvpentrada DECIMAL (5,2), 
	FOREIGN KEY (akgrupo) REFERENCES grupo(pkgrupo), 
	FOREIGN KEY (akescenario) REFERENCES escenario(pkescenario)
);

CREATE TABLE entrada (
	pkentrada INT (11) PRIMARY KEY, 
	akconcierto INT (11), 
	FOREIGN KEY (akconcierto) REFERENCES concierto(pkconcierto)
); 



-- Insertando datos en la tabla festivales_festival
INSERT INTO festival (pkfestival, nombre, anyo, num_personas) VALUES
(1, 'Festival A', '2024-01-01', 5000),
(2, 'Festival B', '2024-02-01', 6000),
(3, 'Festival C', '2024-03-01', 7000),
(4, 'Festival D', '2024-04-01', 8000),
(5, 'Festival E', '2024-05-01', 9000);

-- Insertando datos en la tabla festivales_escenario
INSERT INTO escenario (pkescenario, nombre, afestival, aforo) VALUES
(1, 'Escenario A', 1, 1000),
(2, 'Escenario B', 2, 2000),
(3, 'Escenario C', 3, 3000),
(4, 'Escenario D', 4, 4000),
(5, 'Escenario E', 5, 5000);

-- Insertando datos en la tabla festivales_grupo
INSERT INTO grupo (pkgrupo, nombre, estilo) VALUES
(1, 'Grupo A', 'Rock'),
(2, 'Grupo B', 'Pop'),
(3, 'Grupo C', 'Jazz'),
(4, 'Grupo D', 'Blues'),
(5, 'Grupo E', 'Country');

-- Insertando datos en la tabla festivales_concierto
INSERT INTO concierto (pkconcierto, akgrupo, akescenario, fecha, pvpentrada) VALUES
(1, 1, 1, '2024-06-01', 50.00),
(2, 2, 2, '2024-07-01', 60.00),
(3, 3, 3, '2024-08-01', 70.00),
(4, 4, 4, '2024-09-01', 80.00),
(5, 5, 5, '2024-10-01', 90.00);

-- Insertando datos en la tabla festivales_entrada
INSERT INTO entrada (pkentrada, akconcierto) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

