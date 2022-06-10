#----------------------------------------- CREACION BASE DE DATOS LA GALLINA ELEGANTE -----------------------------------------
#------------------------------------------ TABLA EMPLEADOS (CREACIÓN-INSERTS-ALTER)-------------------------------------------

CREATE TABLE EMPLEADOS (
  CEDULA        int unsigned      NOT NULL,
  NOMBRES       varchar(100)      NOT NULL,
  APELLIDOS     varchar(100)      NOT NULL,
  TELEFONO      int unsigned      DEFAULT NULL,
  CORREO        varchar(50)       NOT NULL,
  CONTRASEÑA    varchar(50)       NOT NULL,
  CUENTA        int               NOT NULL,
  TIPO_EMPLEO   char(2)           NOT NULL,
  SALARIO       float             NOT NULL,
  PRIMARY KEY (CEDULA),
  UNIQUE KEY `cedula_UNIQUE` (CEDULA)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#-------------------------------------------------------------------------------------------------------------------------------
alter table empleados 
modify telefono int unsigned;
#-------------------------------------------------------------------------------------------------------------------------------
insert into empleados (cedula, nombres, apellidos, telefono, correo, contraseña, cuenta, tipo_empleo, salario) 
values(12341212, 'GallinaElegante', "Gerente", 322768460, "gallinaElegante@gmail.com", "123", 12313534, "G", 2000000);

insert into empleados (cedula, nombres, apellidos, telefono, correo, contraseña, cuenta, tipo_empleo, salario) 
(5657676, 'Andres D', "Gomez", 3126669876, "andres@gmail.com", "12", 123567, "M", 1000000);
#-------------------------------------------------------------------------------------------------------------------------------
#------------------------------------------ TABLA DOMICILIARIO (CREACIÓN-INSERTS-ALTER)-----------------------------------------
CREATE TABLE DOMICILIARIO (
   CEDULA_DOMICILIARIO  int       u nsigned NOT NULL,
   ID_SUCURSAL          int                 NOT NULL,
   NOMBRES_DOM          VARCHAR(30)         NOT NULL,
   APELLIDOS_DOM        VARCHAR(30)         NOT NULL,
   TELEFONO_DOM         int  unsigned       NOT NULL,
   CORREO_DOM           VARCHAR(30)         NOT NULL,
   CONTRASENA_DOM       VARCHAR(30)         NOT NULL,
   ESTADO               VARCHAR(2)          NOT NULL,
   CONSTRAINT PK_DOMICILIARIO PRIMARY KEY (CEDULA_DOMICILIARIO));
#-------------------------------------------------------------------------------------------------------------------------------   

insert into domiciliario (CEDULA_DOMICILIARIO,ID_SUCURSAL,NOMBRES_DOM,APELLIDOS_DOM,TELEFONO_DOM,CORREO_DOM,CONTRASENA_DOM,ESTADO)
values(4287704,600,'Andrea','Lopez',321456789,'andre.lopez@gmail.com','3231','O');

insert into domiciliario (CEDULA_DOMICILIARIO,ID_SUCURSAL,NOMBRES_DOM,APELLIDOS_DOM,TELEFONO_DOM,CORREO_DOM,CONTRASENA_DOM,ESTADO)
values(4287705,602,'Niva','Suarez',321456489,'niva.suarez@gmail.com','3241','D');

insert into domiciliario (CEDULA_DOMICILIARIO,ID_SUCURSAL,NOMBRES_DOM,APELLIDOS_DOM,TELEFONO_DOM,CORREO_DOM,CONTRASENA_DOM,ESTADO)
values(4287706,601,'Jhon','Villalba',322456789,'jhon.@gmail.com','3331','D');
#-------------------------------------------------------------------------------------------------------------------------------
#------------------------------------------ TABLA CLIENTES(CREACIÓN-INSERTS)----------------------------------------------
   CREATE TABLE CLIENTES 
(
   CEDULA               int unsigned        NOT NULL,
   ID_CIUDAD            int                 NOT NULL,
   NOMBRES_CLIE         VARCHAR(50)         NOT NULL,
   APELLIDOS_CLIE       VARCHAR(50)         NOT NULL,
   TELEFONO_CLIE        int unsigned        NOT NULL,
   CORREO_CLIE          VARCHAR(50)         NOT NULL,
   CONTRASENA_CLIE      VARCHAR(50)         NOT NULL,
   DIRECCION_CLIE       VARCHAR(100)        NOT NULL,
   CONSTRAINT PK_CLIENTES PRIMARY KEY (CEDULA)
);

#-------------------------------------------------------------------------------------------------------------------------------

insert into clientes(CEDULA,ID_CIUDAD,NOMBRES_CLIE,APELLIDOS_CLIE,TELEFONO_CLIE,CORREO_CLIE,CONTRASENA_CLIE,                      DIRECCION_CLIE)
values(1049655319,2,'pedro','infante',3145678975,'pedro@gmail.com','12345','calle 88 # 45-18');

insert into clientes(CEDULA,ID_CIUDAD,NOMBRES_CLIE,APELLIDOS_CLIE,TELEFONO_CLIE,CORREO_CLIE,CONTRASENA_CLIE,                      DIRECCION_CLIE)
values(1049655318,1,'manuel','acevedo',3145678978,'mauel@gmail.com','123444','calle 76 # 45-18');

insert into clientes(CEDULA,ID_CIUDAD,NOMBRES_CLIE,APELLIDOS_CLIE,TELEFONO_CLIE,CORREO_CLIE,CONTRASENA_CLIE,                      DIRECCION_CLIE)
values(1049655329,3,'elkin','arevalo',3245678975,'elkin@gmail.com','12345','calle 98 # 45-18');
#-------------------------------------------------------------------------------------------------------------------------------
#------------------------------------------ TABLA CIUDAD(CREACIÓN-INSERTS)------------------------------------------------------

CREATE TABLE CIUDAD 
(
   ID_CIUDAD            int               NOT NULL,
   NOMBRE_CIUDAD        VARCHAR(50)       NOT NULL,
   CONSTRAINT PK_CIUDAD PRIMARY KEY (ID_CIUDAD)
);
#-------------------------------------------------------------------------------------------------------------------------------
insert into ciudad(ID_CIUDAD,NOMBRE_CIUDAD)
values(1,'BOGOTA');

insert into ciudad(ID_CIUDAD,NOMBRE_CIUDAD)
values(2,'TUNJA');

insert into ciudad(ID_CIUDAD,NOMBRE_CIUDAD)
values(3,'MEDELLIN');
#-------------------------------------------------------------------------------------------------------------------------------
#------------------------------------------ TABLA CARTA(CREACIÓN-INSERTS)-------------------------------------------------------
CREATE TABLE CARTA 
(
   ID_CARTA             int          NOT NULL,
   CANTIDAD_PLATOS      int          NOT NULL,
   NOMBRE_CARTA		VARCHAR(50)  NOT NULL,
   CONSTRAINT PK_CARTA PRIMARY KEY (ID_CARTA)
);
#-------------------------------------------------------------------------------------------------------------------------------
insert into carta (ID_CARTA,CANTIDAD_PLATOS, NOMBRE_CARTA)
values(50,10, 'MENU ELEGANTE');
#-------------------------------------------------------------------------------------------------------------------------------
#------------------------------------------ TABLA CARTA(CREACIÓN-INSERTS)-------------------------------------------------------
CREATE TABLE PLATO 
(
   ID_PLATO             int               NOT NULL,
   ID_CARTA             int 	          NOT NULL,
   NOMBRE_PLATO         VARCHAR(30)       NOT NULL,
   CONSTRAINT PK_PLATO PRIMARY KEY (ID_PLATO)
);
#-------------------------------------------------------------------------------------------------------------------------------
insert into plato(ID_PLATO,ID_CARTA,NOMBRE_PLATO)
values (21,50,'hamburguesa');

insert into plato(ID_PLATO,ID_CARTA,NOMBRE_PLATO)
values (22,50,'Perro caliente');

insert into plato(ID_PLATO,ID_CARTA,NOMBRE_PLATO)
values (23,50,'Salchipapa');
#-------------------------------------------------------------------------------------------------------------------------------
#------------------------------------------ TABLA DOMICILIO(CREACIÓN-INSERTS)---------------------------------------------------
CREATE TABLE DOMICILIO 
(
   ID_DOMICILIO         int               NOT NULL,
   ID_SUCURSAL          int               NOT NULL,
   CEDULA_CLIENTE  	int   unsigned 	  NOT NULL,
   FECHA_DOMICILIO_Y_HORA_ DATE           NOT NULL,
   CONSTRAINT PK_DOMICILIO PRIMARY KEY (ID_DOMICILIO)
);

#-------------------------------------------------------------------------------------------------------------------------------

alter table domicilio 
modify FECHA_DOMICILIO_Y_HORA_ TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
#-------------------------------------------------------------------------------------------------------------------------------
insert into domicilio (ID_DOMICILIO,ID_SUCURSAL,CEDULA_CLIENTE)
values (100000,600,4287704);

insert into domicilio (ID_DOMICILIO,ID_SUCURSAL,CEDULA_CLIENTE)
values (10001,602,4287705);

insert into domicilio (ID_DOMICILIO,ID_SUCURSAL,CEDULA_CLIENTE)
values (10002,601,4287704);
#-------------------------------------------------------------------------------------------------------------------------------
#------------------------------------------ TABLA ITEM_DOMICILIO (CREACIÓN-INSERTS)---------------------------------------------
CREATE TABLE ITEM_DOMICILIO 
(
   ID_DOMICILIO         int               NOT NULL,
   NOMBRE_PLATO         VARCHAR(30)       NOT NULL,
   CANTIDAD             int               NOT NULL,
   CONSTRAINT PK_ITEM_DOMICILIO PRIMARY KEY (ID_DOMICILIO)
);

#-------------------------------------------------------------------------------------------------------------------------------

insert into ITEM_DOMICILIO(ID_DOMICILIO, NOMBRE_PLATO,CANTIDAD)
values(200,'hamburguesa',2);

insert into ITEM_DOMICILIO(ID_DOMICILIO, NOMBRE_PLATO,CANTIDAD)
values(201,'Perro caliente',1);

insert into ITEM_DOMICILIO(ID_DOMICILIO, NOMBRE_PLATO,CANTIDAD)
values(202,'Salchipapa',3);
#-------------------------------------------------------------------------------------------------------------------------------
#------------------------------------------ TABLA MESAS (CREACIÓN-INSERTS)------------------------------------------------------

CREATE TABLE MESAS 
(
   ID_MESA              int               NOT NULL,
   ID_SUCURSAL          int		  NOT NULL,
   CANT_SILLAS          int               NOT NULL,
   CONSTRAINT PK_MESAS PRIMARY KEY (ID_MESA)
);
#-------------------------------------------------------------------------------------------------------------------------------
insert into mesas (ID_MESA,ID_SUCURSAL,CANT_SILLAS)
values(400,601,4);

insert into mesas (ID_MESA,ID_SUCURSAL,CANT_SILLAS)
values(401,601,6);

insert into mesas (ID_MESA,ID_SUCURSAL,CANT_SILLAS)
values(402,602,3);
#-------------------------------------------------------------------------------------------------------------------------------
#------------------------------------------ TABLA SUCURSAL (CREACIÓN-INSERTS)---------------------------------------------------
CREATE TABLE SUCURSAL 
(
   ID_SUCURSAL          int               NOT NULL,
   ID_CIUDAD            int               NOT NULL,
   DIRECCION_SUCURSAL   VARCHAR(50)       NOT NULL,
   CONSTRAINT PK_SUCURSAL PRIMARY KEY (ID_SUCURSAL)
);
#-------------------------------------------------------------------------------------------------------------------------------
insert into sucursal(ID_SUCURSAL,ID_CIUDAD,DIRECCION_SUCURSAL)
values (600,1,'calle 48 # 45-15');

insert into sucursal(ID_SUCURSAL,ID_CIUDAD,DIRECCION_SUCURSAL)
values (601,2,'calle 58 # 45-15');

insert into sucursal(ID_SUCURSAL,ID_CIUDAD,DIRECCION_SUCURSAL)
values (602,3,'calle 88 # 45-15');
#-------------------------------------------------------------------------------------------------------------------------------
#-------------------------------------------------------------------------------------------------------------------------------
#------------------------------------------------- ALTER TABLE DOMICILIARIO ----------------------------------------------------
ALTER TABLE DOMICILIARIO
ADD CONSTRAINT FK_DOMICILI_R7_SUCURSAL FOREIGN KEY (ID_SUCURSAL)
REFERENCES SUCURSAL (ID_SUCURSAL)
ON DELETE NO ACTION 
ON UPDATE NO ACTION ;

#------------------------------------------------- ALTER TABLE CLIENTES --------------------------------------------------------
ALTER TABLE CLIENTES
ADD CONSTRAINT FK_CLIENTES_R8_CIUDAD FOREIGN KEY (ID_CIUDAD)
REFERENCES CIUDAD (ID_CIUDAD)
ON DELETE NO ACTION 
ON UPDATE NO ACTION ;
#------------------------------------------------- ALTER TABLE DOMICILIO -------------------------------------------------------
ALTER TABLE DOMICILIO
ADD CONSTRAINT FK_DOMICILI_R13_SUCURSAL FOREIGN KEY (ID_SUCURSAL)
REFERENCES SUCURSAL (ID_SUCURSAL);
#------------------------------------------------- ALTER TABLE MESAS -----------------------------------------------------------      
ALTER TABLE MESAS
ADD CONSTRAINT FK_MESAS_R1_SUCURSAL FOREIGN KEY (ID_SUCURSAL)
REFERENCES SUCURSAL (ID_SUCURSAL);
#------------------------------------------------- ALTER TABLE PLATO -----------------------------------------------------------
ALTER TABLE PLATO
ADD CONSTRAINT FK_PLATO_R2_CARTA FOREIGN KEY (ID_CARTA)
REFERENCES CARTA (ID_CARTA);
#------------------------------------------------- ALTER TABLE SUCURSAL --------------------------------------------------------      
ALTER TABLE SUCURSAL
ADD CONSTRAINT FK_SUCURSAL_R10_CIUDAD FOREIGN KEY (ID_CIUDAD)
REFERENCES CIUDAD (ID_CIUDAD);