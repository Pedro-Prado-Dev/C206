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
Consulta_id int,
constraint fk3
foreign key (Consulta_id)
references Consulta(id)
); 

create table Cirurgia(
id int auto_increment primary key,
datad varchar(45) not null,
idPaciente int not null,
constraint fk4
foreign key (idPaciente)
references Paciente (id)
);

create table Medico(
id int not null auto_increment,
nome varchar(45) not null,
idade int not null,
especializacao varchar(45) not null,
cpf varchar(45) not null,
crm varchar(45) not null,
Paciente_id int,
idCirurgia int,
primary key(id), 
constraint fk1 foreign key (Paciente_id) references Paciente(id),
constraint fk2 foreign key (idCirurgia) references Cirurgia(id)
);

create table MedicoFazConsulta(
idMedico int not null,
idConsulta int not null,
primary key(idMedico, idConsulta),
constraint fk5
foreign key (idMedico)
references Medico (id),
constraint fk6
foreign key (idConsulta)
references Consulta (id)
);

select * from Medico;

select * from Paciente;