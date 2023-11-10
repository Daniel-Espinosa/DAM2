create database if not exists Steam_DEG;

use Steam_DEG;


-- CREATE USER 'daniel1'@'localhost' IDENTIFIED BY '1234';
-- CREATE USER 'daniel2'@'localhost' IDENTIFIED BY '1234';
-- GRANT ALL PRIVILEGES ON Steam_DEG.* TO 'daniel1'@'localhost';
-- GRANT ALL PRIVILEGES ON Steam_DEG.* TO 'daniel2'@'localhost';

create table juego (
id_juego int unsigned auto_increment,
nombre varchar(100),
tipo varchar(100),
primary key (id_juego)
);
 
 
create table jugador (
id_jugador int unsigned auto_increment,
alias varchar(100),
nombre varchar(100),
primary key (id_jugador)
);

 
create table sesion (
id_jugador int unsigned,
id_juego int unsigned,
fecha timestamp default CURRENT_TIMESTAMP,
primary key (id_jugador,id_juego,fecha),
constraint fk_sesion_juego foreign key (id_juego) references juego(id_juego),
constraint fk_sesion_jugador foreign key (id_jugador) references jugador(id_jugador)
)