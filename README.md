# Dev.-Sistemas - APP



##Local dos projetos de app No curso
##Terminar em casa 30.04 

###Use o NetBeans 
###Use a base dos views no drive <a>https://drive.google.com/drive/quota<a/>

create database eletroBase;

use eletroBase;

create table eletrodomestico(
id int auto_increment primary key,
nome varchar(50),
marca varchar(50),
voltagem int, 
preco double
);	

select * from eletrodomestico;
