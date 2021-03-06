CREATE SEQUENCE IF NOT EXISTS seq_tb_pilot
     INCREMENT  BY  1
     START  WITH  1;

create table IF NOT EXISTS tb_pilot (
plid             bigint primary key NOT NULL DEFAULT nextval('seq_tb_pilot'), 
plname           varchar (150) NOT NULL,
plactive         boolean
);

ALTER SEQUENCE seq_tb_pilot OWNED BY tb_pilot.plid;


CREATE SEQUENCE IF NOT EXISTS seq_tb_plane
     INCREMENT  BY  1
     START  WITH  1;

create table IF NOT EXISTS tb_plane (
pnid             bigint primary key NOT NULL DEFAULT nextval('seq_tb_plane'), 
pnmodel          varchar (150) NOT NULL,
pnidentcode      varchar (150) NOT NULL
);

ALTER SEQUENCE seq_tb_plane OWNED BY tb_plane.pnid;


CREATE SEQUENCE IF NOT EXISTS seq_tb_city
     INCREMENT  BY  1
     START  WITH  1;

create table IF NOT EXISTS tb_city (
ciid         bigint primary key NOT NULL DEFAULT nextval('seq_tb_city'), 
ciname           varchar (150) NOT NULL
);

ALTER SEQUENCE seq_tb_city OWNED BY tb_city.ciid;


CREATE SEQUENCE IF NOT EXISTS seq_tb_status
     INCREMENT  BY  1
     START  WITH  1;

create table IF NOT EXISTS tb_status (
stid             bigint primary key NOT NULL DEFAULT nextval('seq_tb_status'), 
stdescription    varchar (150) NOT NULL
);

ALTER SEQUENCE seq_tb_status OWNED BY tb_status.stid;


CREATE SEQUENCE IF NOT EXISTS seq_tb_flight
     INCREMENT  BY  1
     START  WITH  1;

create table IF NOT EXISTS tb_flight (
flid                  bigint primary key NOT NULL DEFAULT nextval('seq_tb_flight'), 
flplaneid             bigint not null,
flpilotid             bigint not null,
fldepartcityid        bigint not null,
flarrivecityid        bigint not null,
fldepartdate          timestamp ,
flarriveddate         timestamp ,
flstatusid            bigint not null
);

ALTER SEQUENCE seq_tb_flight OWNED BY tb_flight.flid;

insert into tb_status (stdescription) values (
'EN ROUTE ON TIME'
);

insert into tb_status (stdescription) values (
'EN ROUTE DELAY'
);

insert into tb_status (stdescription) values (
'LANDED'
);

insert into tb_status (stdescription) values (
'SCHEDULED'
);

insert into tb_status (stdescription) values (
'CANCELED'
);


insert into tb_city (ciname) values (
'SAO PAULO'
);

insert into tb_city (ciname) values (
'MANAUS'
);

insert into tb_city (ciname) values (
'RIO DE JANEIRO'
);

insert into tb_city (ciname) values (
'BRASILIA'
);

insert into tb_plane (pnmodel,pnidentcode) values (
'B772',
'G38265'
);

insert into tb_plane (pnmodel,pnidentcode) values (
'B772',
'G31549'
);

insert into tb_plane (pnmodel,pnidentcode) values (
'B738',
'G31859'
);

insert into tb_plane (pnmodel,pnidentcode) values (
'B738',
'G35467'
);

insert into tb_pilot (plname, plactive) VALUES (
'Joao da Silva',
true
);

insert into tb_pilot (plname, plactive) VALUES (
'Jose de Souza',
true
);

insert into tb_pilot (plname, plactive) VALUES (
'John dos Santos',
true
);

insert into tb_pilot (plname, plactive) VALUES (
'Jonatan Oliveira',
true
);

insert into tb_pilot (plname, plactive) VALUES (
'Julio Cesar',
false
);

insert into tb_flight (flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) values (
4,
5,
1,
3,
'2022-01-01 22:20:00-03',
'2022-01-02 00:30:00-03',
3
);

insert into tb_flight (flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) values (
2,
5,
1,
2,
'2022-02-16 16:20:00-03',
'2022-02-16 17:30:00-03',
5
);

insert into tb_flight (flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) values (
2,
5,
2,
4,
'2022-02-17 16:20:00-03',
'2022-02-18 17:30:00-03',
5
);

insert into tb_flight (flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) values (
3,
2,
4,
1,
'2022-03-10 12:20:00-03',
'2022-03-10 13:30:00-03',
3
);

insert into tb_flight (flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) values (
4,
3,
2,
3,
'2022-04-11 13:20:00-03',
'2022-04-11 14:30:00-03',
3
);

insert into tb_flight (flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) values (
1,
1,
1,
2,
'2022-05-31 16:20:00-03',
'2022-05-31 17:30:00-03',
1
);

insert into tb_flight (flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) values (
2,
2,
3,
4,
'2022-05-31 13:20:00-03',
'2022-05-31 16:30:00-03',
2
);

insert into tb_flight (flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) values (
3,
3,
2,
4,
'2022-05-31 13:20:00-03',
'2022-05-31 16:30:00-03',
1
);

insert into tb_flight (flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) values (
4,
4,
1,
3,
'2022-05-31 13:40:00-03',
'2022-05-31 14:50:00-03',
1
);

insert into tb_flight (flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) values (
1,
1,
2,
1,
'2022-06-01 16:20:00-03',
'2022-06-01 17:30:00-03',
4
);

insert into tb_flight (flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) values (
2,
2,
4,
1,
'2022-06-01 12:10:00-03',
'2022-06-01 13:20:00-03',
4
);