/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     1/5/2022 17:34:07                            */
/*==============================================================*/


drop table if exists VENDEDOR;

drop table if exists VENDEDORLOGIN;

/*==============================================================*/
/* Table: VENDEDOR                                              */
/*==============================================================*/
create table VENDEDOR
(
   IDVR                 int not null auto_increment,
   NOMBREVR             varchar(50) not null,
   CIVR                 varchar(20) not null,
   DIRECCIONVR          varchar(50) not null,
   TELEFONOVR           int not null,
   CORREOELECTRONICOVR  varchar(50),
   FECHADENACIMIENTOVR  date not null,
   primary key (IDVR)
);

/*==============================================================*/
/* Table: VENDEDORLOGIN                                         */
/*==============================================================*/
create table VENDEDORLOGIN
(
   IDLOGINVR            int not null auto_increment,
   IDVR                 int not null,
   USUARIOLOGINVR       varchar(20) not null,
   CONTRASENIALOGINVR   varchar(20) not null,
   primary key (IDLOGINVR)
);

alter table VENDEDORLOGIN add constraint FK_TIENE foreign key (IDVR)
      references VENDEDOR (IDVR) on delete restrict on update restrict;

INSERT INTO `vendedor` (`IDVR`, `NOMBREVR`, `CIVR`, `DIRECCIONVR`, `TELEFONOVR`, `CORREOELECTRONICOVR`, `FECHADENACIMIENTOVR`) VALUES
	(1, 'carlos', '12345678', 'ayacucho', 71450557, 'correo@gmail.com', '2022-04-01');
INSERT INTO `vendedorlogin` (`IDLOGINVR`, `IDVR`, `USUARIOLOGINVR`, `CONTRASENIALOGINVR`) VALUES
	(1, 1, 'contraseña', 'contraseña');