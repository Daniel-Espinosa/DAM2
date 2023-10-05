create database if not exists actividad3;

use actividad3;

create table if not exists paciente (
numHistorial int(5) primary key
);

create table if not exists medico (
codidentificacion int(10) primary key
);

create table if not exists ingreso(
numingreso int(10) unsigned auto_increment,
numHistorial int(5),
codidentificacion int(10),
Constraint PK_ingreso primary key (numingreso),
Constraint FK_ingreso_paciente foreign key (numHistorial) references paciente(numHistorial),
Constraint FK_ingreso_medico foreign key (codidentificacion) references medico(codidentificacion)
);


insert into paciente values
('1'),
('2'),
('3');

insert into medico values
('1001'),
('1002'),
('1003');

insert into ingreso(numHistorial,codidentificacion)  values
('1','1001'),
('2','1002'),
('3','1003');