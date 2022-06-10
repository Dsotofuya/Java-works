create database g_e_db;

create user gallina_elegante identified by a123;

grant select, insert, update, delete, create, drop, alter 
on g_e_db.*
to gallina_elegante;

use g_e_db2; 
