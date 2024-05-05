CREATE database Clima;
use Clima;
CREATE TABLE Arquivo (
    IdArquivo varchar(20) PRIMARY KEY,
    Cidade VARCHAR(100),
    Estacao VARCHAR(100)
);

CREATE TABLE Registro (
    Indice varchar(40),
    IdArquivo varchar(20),
    Data varchar(20),
    Hora varchar(20),
    Valor VARCHAR(20),
    primary key(Indice,IdArquivo,Data,Hora)
);

select * from Arquivo;
select * from Registro;

drop table registro;
drop table arquivo;

SELECT COUNT(*)  FROM registro;
Select count(*) from registro IdArquivo