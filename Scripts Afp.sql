 create table if not exists Afp (Id serial primary key not null , 
Descripcion varchar(250) not null unique );
insert into Afp ( Descripcion) values ( 'PRIMA'), ('INTEGRA'), ('HABITA'), ('PROFUTURO') ; 
  
create table IF NOT EXISTS Cliente (
Id serial primary key not null  ,
Nombres varchar(250) not null, 
Apellidos varchar(250) not null,
Dni int not null, 
Telefono varchar(15) not null, 
Correo varchar(30 ) not null, 
IdAfp int references Afp(id) not null
); 
insert into cliente (Nombres, Apellidos, Dni, Telefono , Correo, IdAfp) values 
('Juan' , 'Calla' , 44840472 , '45889622', 'builderdotnet@gmail.com', 1),
('Russell' , 'Calla' , 44110472 , '57852142', 'russellcalla.pe@gmail.com', 2),
('Axell' , 'Calla' , 44841672 , '44889622', 'developer@hotmail.com', 3),
('Luz' , 'Jayo' , 47428115 , '47862258', 'ljayo@gmail.com', 1) ;

create table IF NOT EXISTS InformacionCliente (
Id serial primary key not null  ,
IdCliente int references Cliente(id) unique not null, 
IdAfp int references Afp(id) not null, 
MontoDisponible decimal(14,4) not null , 
FechaRetiro TIMESTAMP not null,  --Disponible el retiro
NroCuenta  varchar(250) unique not null 
); 

insert into InformacionCliente (IdCliente, IdAfp, MontoDisponible, FechaRetiro, NroCuenta) values
(1, 1, 18000, now(), '125-0155-0045552'), 
(2, 2, 8000, now(), '125-1245-0045555'), 
(3, 3, 12000, now(), '125-0155-0045452'), 
(4, 1, 18000, now(), '145-0155-0045552');  

create table if not exists RetiroCliente (
Id serial primary key not null  ,
IdCliente int references Cliente(id) not null, 
IdAfp int references Afp(id) not null, 
MontoRetiro decimal(14,4) not null , 
FechaRetiro TIMESTAMP not null 
); 

