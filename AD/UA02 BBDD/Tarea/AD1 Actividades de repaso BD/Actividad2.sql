create database if not exists actividad2;

use actividad2;

create table if not exists cliente (
codCliente int(5) primary key,
);

create table if not exists articulo (
codArticulo int(10) primary key,
);

create table if not exists compra(
codCliente int(5),
codArticulo int(10),
fecha date,
unidades int(10),
Constraint PK_trabaja primary key (codCliente,codArticulo),
Constraint FK_compra_cliente foreign key (codCliente) references cliente(codCliente),
Constraint FK_compra_articulo foreign key (codArticulo) references articulo(codArticulo)
);


insert into cliente values
('1'),
('2'),
('3');

insert into articulo values
('1001'),
('1002'),
('1003');

insert into compra  values
('1','1001',19990101,10),
('2','1002',19980203,5),
('3','1003',19970407,7);






