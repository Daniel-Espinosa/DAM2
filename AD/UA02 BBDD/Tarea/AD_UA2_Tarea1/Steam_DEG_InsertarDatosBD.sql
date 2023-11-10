use Steam_DEG;

insert into juego (nombre, tipo) values
('Super Mario Bros', 'Plataformas'),
('Call of Duty', 'Shooter'),
('Minecraft', 'Sandbox'),
('The Legend of Zelda', 'Aventura'),
('FIFA 23', 'Deportes'),
('The Sims 4', 'Simulación'),
('Grand Theft Auto V', 'Acción'),
('Pokémon Espada y Escudo', 'Rol'),
('Animal Crossing: new Horizons', 'Estrategia'),
('Among Us', 'Social');

insert into jugador (alias, nombre) values
('LaraCroft', 'Dolores García'),
('MasterChief', 'Francisco López'),
('Kratos', 'Rafael Sánchez'),
('Link', 'David González'),
('Mario', 'Carlos García'),
('Sonic', 'Jorge Sánchez'),
('Geralt', 'Daniel Martínez'),
('NathanDrake', 'Pedro Díaz'),
('Ellie', 'Sara Pérez'),
('ArthurMorgan', 'Laura Rodríguez');

insert into sesion (id_jugador, id_juego) values
(1,3),
(2,4),
(3,5),
(4,1),
(5,2),
(6,6),
(7,7),
(8,8),
(9,10),
(10,9),
(1,10),
(2,5),
(3,2),
(4,3),
(5,7),
(6,9),
(7,4),
(8,6),
(9,1);
