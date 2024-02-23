create database almacen;
use almacen;
 
create table categoria(
	pkcategoria int primary key,
	nombre varchar(80) not null
);
create table producto (
	pkproducto int primary key,
	akcategoria int not null,
	nombre varchar(80) not null,	
	pvp decimal(8,2) not null,
	stock int,
	FOREIGN key (akcategoria) references categoria (pkcategoria)
);
insert into categoria values (1001, "frutas y verduras");
insert into categoria values (2001, "legumbres");
insert into categoria values(3001, "higiene");
 
insert into producto values (1, 1001, "mandarinas", 2.55, 28);
insert into producto values (2, 1001, "fresas",  5.55, 20);
insert into producto values (4, 2001, "lentejas", 1.15, 58);
insert into producto values (5, 3001, "gel de ducha", 3.52, 12);
insert into producto values (6, 3001, "jabón de manos", 0.55, 28);