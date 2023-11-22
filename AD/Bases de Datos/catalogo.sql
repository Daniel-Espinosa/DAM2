create database catalogo;
use catalogo;

create table categoria(
    pkcategoria int primary key,
	nombre varchar(50)
);

create table producto (
	pkproducto int PRIMARY KEY,
	nombre varchar(80),
	pvp decimal(6,2),
	stock int,
	fkcategoria int not null,
	foreign key (fkcategoria) references categoria (pkcategoria)
);

insert into categoria values(100, 'Categoria cien');
insert into categoria values(200, 'Categoria doscientos');

insert into producto values (1, 'Producto 1', 20.10, 125, 100);
insert into producto values (2, 'Producto 2', 10.10, 125, 100);
insert into producto values (3, 'Producto 3', 20.10, 125, 200);
insert into producto values (4, 'Producto 4', 20.10, 125, 200);