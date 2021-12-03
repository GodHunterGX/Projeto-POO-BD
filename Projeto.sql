drop database if exists registro;
create database registro;
use registro;

create table if not exists Pessoa(
	id int not null auto_increment,
    nome varchar(100) not null,
    data_nascimento varchar(30) not null,
    cpf varchar(40) not null,
    sexo varchar(10) not null,
    endereco varchar(100) not null,
    primary key(id)
);

create table if not exists Aluno(
    matricula int not null auto_increment primary key,
    PRIMARY KEY (matricula),
	idPessoa int not null,
    CONSTRAINT fk_idPessoa
    FOREIGN KEY (idPessoa)
    REFERENCES Pessoa(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

create table if not exists Instrutor(
    cargo varchar(50) not null,
    idPessoa int not null,
	CONSTRAINT fk_idPessoa
    FOREIGN KEY (idPessoa)
    REFERENCES Pessoa(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

create table if not exists Endereco(
	id int not null auto_increment,
    bairro varchar(50) not null,
    cep varchar(20) not null,
    primary key(id)
);

INSERT INTO Pessoa VALUES (1,"Eduardo","28/06/1999","123.456.789-10","M","Av. João de Camargo, 510");
INSERT INTO Aluno VALUES (1491);
INSERT INTO Instrutor VALUES ("Monitor");
INSERT INTO Endereco VALUES (1,"Centro","37540-000");

select * from Pessoa;
select * from Aluno;
select * from Instrutor;
select * from Endereco;
