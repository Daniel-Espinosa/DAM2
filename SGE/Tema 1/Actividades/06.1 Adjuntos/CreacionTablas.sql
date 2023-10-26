--Zoo cuya clave primaria será ID, un número único que identificará cada zoo.
--También contendrá el nombre, la ciudad, el tamaño y presupuesto anual de cada zoo.

 

Create table if not exists zoo(
	zooID SERIAL primary key,
	nombre varchar(100) not null,
	ciudad varchar(100) not null,
	tamano double precision not null,
	presupuestoAnual double precision not null
);

 

--b.	Especie animal que almacene el nombre común y el nombre científico,
-- la familia a la que pertenece y si está en peligro de extinción.

Create table if not exists especie (
	especieID SERIAL primary key,
	nombreComun varchar(100) not null,
	nombreCientifico varchar(200) not null,
	familiaAnimal varchar(200) not null,
	peligroExtincion boolean not null
);

 

--c.	Animal cuya clave primaria será ID, un número único que identificará cada animal.
-- También se indicará a qué zoo pertenece, cuál es su especie, año de nacimiento y país de origen.

 

Create table if not exists animal (
	animalID SERIAL primary key,
	zooID int not null,
	especieID int not null,
	anoNacimiento date not null,
	paisNacimiento varchar(200) not null,
	CONSTRAINT fk_animal_especie FOREIGN KEY (especieID) REFERENCES especie(especieID),
	CONSTRAINT fk_animal_zoo FOREIGN KEY (zooID) REFERENCES zoo(zooID)
);