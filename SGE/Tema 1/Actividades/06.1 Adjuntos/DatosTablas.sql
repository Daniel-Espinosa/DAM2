--Datos zoo
insert into zoo(nombre,ciudad,tamano,presupuestoanual) values
('Cabarceno','Penagos',7500000,3000000),
('Zoo de Santillana','Santillana',6000,500000),
('Central Park','New York',3000,750000),
('Acuario de Gijón','Gijon',2000,300000),
('Loro Parque','Puerto de la Cruz',13500,2000000),
('Zoo Invent 1','Caracas',12000,250000),
('Zoo Invent 2','Trujillo',17000,230000),
('Zoo Invent 3','Bogota',21000,370000),
('Zoo Invent 4','Maracaibo',14000,140000),
('Zoo Invent 5','Valencia',27000,1000000);

--datos Especie
insert into especie(nombrecomun,nombrecientifico,familiaanimal,peligroextincion) values
('Perro','Canis familiaris','Canidos',false),
('Gato','Felis silvestris catus','Felidae',false),
('Delfín','Delphinidae','cetáceos odontocetos',false),
('Orca','Orcinus orca','cetáceos odontocetos',false),
('Panda','Ailuropoda melanoleuca','Ursidae',true ),
('Panda rojo','Ailurus fulgens','Ailuridae',true),
('Loro tricolor','Lorius lory','Psittaculidae',false),
('Guacamaya','Ara','Psittacidae',false),
('Iguana del Caribe','Iguana delicatissima','Iguanidae',true),
('Ñu Azul','Connochaetes taurinus','Bovidae',false);

--datos Animal
insert into animal(zooid,especieid,anonacimiento,paisnacimiento) values
(1,2,'2018-01-01','Canada'),
(5,3,'2019-01-01','Japon'),
(5,3,'2020-01-01','Japon'),
(6,5,'2021-01-01','Japon'),
(6,5,'2022-01-01','Japon'),
(7,1,'2018-01-01','Venezuela'),
(7,1,'2019-01-01','Venezuela'),
(2,2,'2020-01-01','Portugal'),
(10,1,'2021-01-01','Nigeria'),
(9,4,'2022-01-01','Puerto Rico');
