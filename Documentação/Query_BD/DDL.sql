CREATE database Clima;
use Clima;
CREATE TABLE Parametros(
	IndiceP varchar(40),
	Maximo int,
	Minimo int
);
CREATE TABLE Arquivo (
    IdArquivo varchar(20) PRIMARY KEY,
    Cidade VARCHAR(100),
    Estacao VARCHAR(100)
);

CREATE TABLE Registro (
    IdArquivo varchar(20),
    Data varchar(20),
    Hora varchar(20),
    Indice varchar(40),
    Valor VARCHAR(20),
    suspeito varchar(5),
    primary key(Indice,IdArquivo,Data,Hora),
    foreign key(IdArquivo) references Arquivo(IdArquivo)
);

create table Estacao(
	idEstacao varchar(10) primary key not null,
	nomeEstacao varchar (100),
	Latitude varchar(20),
	Longitude varchar(20)
);

create table Cidade(
	siglaCidade varchar(10) primary key not null,
	nomeCidade varchar (50)
);

drop table Parametros;
drop table registro;
drop table arquivo;
drop table estacao;
drop table cidade;
