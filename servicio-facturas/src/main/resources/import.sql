

INSERT INTO regiones(id, nombre) VALUES (1, 'Bogota');
INSERT INTO regiones(id, nombre) VALUES (2, 'Cartagena');
INSERT INTO regiones(id, nombre) VALUES (3, 'Bucaramanga');
INSERT INTO regiones(id, nombre) VALUES (4, 'Cali');



INSERT INTO vendedores(nombre,apellido,nivel,create_at,documento,direccion,email,telefono,id_Referido,region_id) VALUES('Johan','Niño','Amateur', NOW(),'1101696849','carrera 68 # 75a-14','johanmaury@hotmail.com','3213510966','1',1);
INSERT INTO vendedores(nombre,apellido,nivel,create_at,documento,direccion,email,telefono,id_Referido,region_id) VALUES('Jennifer' ,'galvis','Avanzado', NOW(),'10165874','calle 8 #9-21','jennifer@gmail.com','32036548','1',2);
INSERT INTO vendedores(nombre,apellido,nivel,create_at,documento,direccion,email,telefono,id_Referido,region_id) VALUES('Jonathan','Vasques','Avanzado', NOW(),'10165874','calle 8 #9-21','jennifer@gmail.com','32036548','1',3);
INSERT INTO vendedores(nombre,apellido,nivel,create_at,documento,direccion,email,telefono,id_Referido,region_id) VALUES('Ruben','Doblas','Avanzado', NOW(),'10165874','calle 8 #9-21','jennifer@gmail.com','32036548','1',4);


INSERT productos(codigo,nombre,precio,create_at) VALUES('100','Bandas elasticas', 80000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('200','Guantes', 20000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('300','Raqueta', 30000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('400','Arco', 40000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('500','Patines', 500000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('600','Bate de beisbol', 60000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('700','Tabla de surf', 70000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('800','Pelota de golf', 80000,NOW());



INSERT productos(codigo,nombre,precio,create_at) VALUES('900', 'Iphone 11', 10000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('1000', 'Galaxy A21', 20000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('1100', 'Iphone 8', 3000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('1200', 'LG V60', 40000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('1300', 'LG V50', 500000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('1400', 'LG G8', 60000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('1500', 'Nokia 6310', 70000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('1600', 'Nokia C30', 80000,NOW());

INSERT productos(codigo,nombre,precio,create_at) VALUES('1700', 'Alimento Proteinico-240 gr', 40000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('1800', 'Barra con Proteina-Sabor vainilla', 450000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('1900', 'Bebida Herbal-Limon-102 gr', 900000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('2000', 'Herbal Aloe Concentrado-mango-473 ml', 480000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('2100', 'Herbal Aloe Concentrado-Original-473 ml', 500000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('2200', 'Crema Humectante', 300000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('2300', 'Talcos', 140000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('2400', 'Aceite para el cabello', 9000,NOW());

INSERT productos(codigo,nombre,precio,create_at) VALUES('2500', 'Anillo de dragon', 120000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('2600', 'Collar itachi', 20000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('2700', 'Guantes', 30000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('2800', 'Correa gucci', 40000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('2900', 'Cartera azul', 5000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('3000', 'Aretes', 60000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('3100', 'Manilla', 70500,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('3200', 'Bolso de mano', 600500,NOW());

INSERT productos(codigo,nombre,precio,create_at) VALUES('3300', 'Camiseta roja', 705000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('3400', 'Jean negro', 800200,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('3500', 'Zapatos cafes', 600500,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('3600', 'Tenis nike', 70500,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('3700', 'Medias grises', 15000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('3800', 'Boxers', 600150,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('3900', 'Zandalias', 65000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('4000', 'Chaqueta', 48000,NOW());

INSERT productos(codigo,nombre,precio,create_at) VALUES('4100', 'Manga Naruto', 20000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('4200', 'Manga Bleach', 300000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('4300', 'Manga Dragon Ball', 10000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('4400', 'Manga Boku no hero', 15000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('4500', 'Manga Shingeki no kyoyin', 14000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('4600', 'Manga Black clover', 18000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('4700', 'Manga Tokyo revenge', 16000,NOW());
INSERT productos(codigo,nombre,precio,create_at) VALUES('4800', 'Manga Katekyo no hitman', 16000,NOW());


INSERT INTO facturas(descripcion,observacion,cliente_id,create_at) VALUES ('Factura de deporte',null,1,NOW());
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,1,1);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(2,1,4);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,1,5);

INSERT INTO facturas(descripcion,observacion,cliente_id,create_at) VALUES ('Factura de salud',null,2,NOW());
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,5,17);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,2,19);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,4,20);



INSERT INTO facturas(descripcion,observacion,cliente_id,create_at) VALUES ('Factura de Tecnologia',null,1,NOW());
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,3,9);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,4,10);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,6,11);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,2,12);

INSERT INTO facturas(descripcion,observacion,cliente_id,create_at) VALUES ('Factura de Accesorios',null,3,NOW());
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,3,25);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,4,26);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,6,27);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,2,28);

INSERT INTO facturas(descripcion,observacion,cliente_id,create_at) VALUES ('Factura de Ropa',null,1,NOW());
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,3,34);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,4,35);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,5,36);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,3,37);

INSERT INTO facturas(descripcion,observacion,cliente_id,create_at) VALUES ('Factura Anime',null,4,NOW());
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(7,3,20);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(7,4,21);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(7,2,22);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(7,5,23);


INSERT INTO facturas(descripcion,observacion,cliente_id,create_at) VALUES ('Factura de salud',null,2,NOW());
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(7,5,21);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(7,2,22);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(7,4,23);





