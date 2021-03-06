DELETE FROM tb_city;

INSERT INTO tb_city (ciid, ciname) VALUES (1, 'SAO PAULO');
INSERT INTO tb_city (ciid, ciname) VALUES (2, 'MANAUS');
INSERT INTO tb_city (ciid, ciname) VALUES (3, 'RIO DE JANEIRO');
INSERT INTO tb_city (ciid, ciname) VALUES (4, 'BRASILIA');

DELETE FROM tb_pilot;

INSERT INTO tb_pilot (plid, plname, plactive) VALUES (1, 'Joao da Silva', true);
INSERT INTO tb_pilot (plid, plname, plactive) VALUES (2, 'Jose de Souza', true);
INSERT INTO tb_pilot (plid, plname, plactive) VALUES (3, 'John dos Santos', true);
INSERT INTO tb_pilot (plid, plname, plactive) VALUES (4, 'Jonatan Oliveira', true);
INSERT INTO tb_pilot (plid, plname, plactive) VALUES (5, 'Julio Cesar', false);

DELETE FROM tb_plane;

INSERT INTO tb_plane (pnid, pnmodel, pnidentcode) VALUES (1, 'B772', 'G38265');
INSERT INTO tb_plane (pnid, pnmodel, pnidentcode) VALUES (2, 'B772', 'G31549');
INSERT INTO tb_plane (pnid, pnmodel, pnidentcode) VALUES (3, 'B738', 'G31859');
INSERT INTO tb_plane (pnid, pnmodel, pnidentcode) VALUES (4, 'B738', 'G35467');

DELETE FROM tb_status;

INSERT INTO tb_status (stid, stdescription) VALUES (1, 'EN ROUTE ON TIME');
INSERT INTO tb_status (stid, stdescription) VALUES (2, 'EN ROUTE DELAY');
INSERT INTO tb_status (stid, stdescription) VALUES (3, 'LANDED');
INSERT INTO tb_status (stid, stdescription) VALUES (4, 'SCHEDULED');
INSERT INTO tb_status (stid, stdescription) VALUES (5, 'CANCELED');

DELETE FROM tb_flight;

INSERT INTO tb_flight (flid, flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) VALUES (1, 4, 5, 1, 3, '2022-01-01 22:20:00', '2022-01-02 00:30:00', 3);
INSERT INTO tb_flight (flid, flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) VALUES (2, 2, 5, 1, 2, '2022-02-16 16:20:00', '2022-02-16 17:30:00', 5);
INSERT INTO tb_flight (flid, flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) VALUES (3, 2, 5, 2, 4, '2022-02-17 16:20:00', '2022-02-18 17:30:00', 5);
INSERT INTO tb_flight (flid, flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) VALUES (4, 3, 2, 4, 1, '2022-03-10 12:20:00', '2022-03-10 13:30:00', 3);
INSERT INTO tb_flight (flid, flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) VALUES (5, 4, 3, 2, 3, '2022-04-11 13:20:00', '2022-04-11 14:30:00', 3);
INSERT INTO tb_flight (flid, flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) VALUES (6, 1, 1, 1, 2, '2022-05-31 16:20:00', '2022-05-31 17:30:00', 1);
INSERT INTO tb_flight (flid, flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) VALUES (7, 2, 2, 3, 4, '2022-05-31 13:20:00', '2022-05-31 16:30:00', 2);
INSERT INTO tb_flight (flid, flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) VALUES (8, 3, 3, 2, 4, '2022-05-31 13:20:00', '2022-05-31 16:30:00', 1);
INSERT INTO tb_flight (flid, flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) VALUES (9, 4, 4, 1, 3, '2022-05-31 13:40:00', '2022-05-31 14:50:00', 1);
INSERT INTO tb_flight (flid, flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) VALUES (10, 1, 1, 2, 1, '2022-06-01 16:20:00', '2022-06-01 17:30:00', 4);
INSERT INTO tb_flight (flid, flplaneid, flpilotid, fldepartcityid, flarrivecityid, fldepartdate, flarriveddate, flstatusid) VALUES (11, 2, 2, 4, 1, '2022-06-01 12:10:00', '2022-06-01 13:20:00', 4);