drop database if exists clinica;
create database clinica;
use clinica;

create table Hospital(
id int auto_increment primary key,
nome varchar(45) not null
);

create table Pessoa(
id int auto_increment primary key,
nome varchar(45) not null,
idade int not null,
cpf varchar(45) not null
);

create table Consulta(
id int auto_increment primary key,
datad varchar(45) not null
);

create table Paciente(
id int auto_increment primary key,
nome varchar(45) not null,
idade int not null,
cpf varchar(45) not null,
idConsulta int,
constraint fk3
foreign key (idConsulta)
references Consulta(id)
ON DELETE CASCADE 
ON UPDATE CASCADE
); 

create table Cirurgia(
id int auto_increment primary key,
datad varchar(45) not null,
idPaciente int,
constraint fk4
foreign key (idPaciente)
references Paciente (id)
ON DELETE CASCADE 
ON UPDATE CASCADE
);

create table Medico(
id int auto_increment,
nome varchar(45) not null,
idade int not null,
especializacao varchar(45) not null,
cpf varchar(45) not null,
crm varchar(45) not null,
idPaciente int,
idCirurgia int,
primary key(id), 
constraint fk1 
foreign key (idPaciente)
references Paciente(id)
ON DELETE CASCADE 
ON UPDATE CASCADE,
constraint fk2 
foreign key (idCirurgia) 
references Cirurgia(id)
ON DELETE CASCADE 
ON UPDATE CASCADE
);

create table MedicoFazConsulta(
idMedico int,
idConsulta int,
primary key(idMedico, idConsulta),
constraint fk5
foreign key (idMedico)
references Medico (id)
ON DELETE CASCADE 
ON UPDATE CASCADE,
constraint fk6
foreign key (idConsulta)
references Consulta (id)
ON DELETE CASCADE 
ON UPDATE CASCADE
);

insert into Consulta values (1, '22.06.2022'); 

insert into Paciente values (1, 'Matheus', 10, '14789632500', 1); 

insert into Cirurgia values (1, '10.07.2022', 1); 

insert into Medico values (1, 'Jorge', 50, 'Pediatria', '14952079600', '3711', 1, 1);

select * from Medico;

select * from Paciente;

select * from Consulta;

select * from Cirurgia;