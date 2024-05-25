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

select * from Parametros;
select * from Arquivo;
select * from Registro;

drop table Parametros;
drop table registro;
drop table arquivo;

SELECT COUNT(*)  FROM registro;
Select count(*) from registro IdArquivo