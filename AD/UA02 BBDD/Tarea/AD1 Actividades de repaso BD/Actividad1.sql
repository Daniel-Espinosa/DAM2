create database if not exists actividad1;

use actividad1;

create table if not exists empleado (
nif varchar(9) primary key,
nombre varchar(100),
fechaNac date
);

create table if not exists departamento (
codDpto int(10) primary key,
nombre varchar(100),
presupuesto int(100)
);

create table if not exists trabaja (
nif_empleado varchar(09),
codDpto_departamento int(10),
Constraint PK_trabaja primary key (nif_empleado,codDpto_departamento),
Constraint FK_empleado_trabaja foreign key (nif_empleado) references empleado(nif),
Constraint FK_departamento_trabaja foreign key (codDpto_departamento) references departamento(codDpto)
);


insert into empleado values
('12345678A','Daniel Espinosa',19000101),
('12345678B','Albano Diez',19010202),
('12345678C','Ramiro Gutierrez',19020303);

insert into departamento  values
('1','produccion',100000),
('2','calidad',54684616),
('3','compras',68764);

insert into trabaja values
('12345678A','1'),
('12345678B','2'),
('12345678C','3');





