INSERT INTO roles(nombre) VALUES('ROLE_ADMIN');
INSERT INTO roles(nombre) VALUES('ROLE_USER');

INSERT INTO usuarios(username,password,enabled,nombre,email) VALUES('user', '12345',1,'usuario','usuario@gmail.com');
INSERT INTO usuarios(username,password,enabled,nombre,email) VALUES('admin','123456',1,'administrador','admin@gmail.com');


INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(1,2);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(2,1);


