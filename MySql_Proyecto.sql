drop schema Verduleria ;
drop user 'admin';

CREATE SCHEMA Verduleria;

CREATE USER 'admin'@'%' IDENTIFIED BY 'password';

GRANT ALL privileges ON Verduleria.* to 'admin'@'%';
flush privileges;

CREATE TABLE Verduleria.usuarios (
	id_usuario int not null auto_increment primary key,
    username varchar(30),
    password varchar(200))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE Verduleria.cargo (
	id_cargo int not null auto_increment primary key,
    cargo varchar(30),
    id_usuario int,
    foreign key fk_cargo_usuario (id_usuario) references usuarios(id_usuario))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE Verduleria.empleado (
	id_empleado int not null auto_increment primary key, 
    nombre varchar(30) not null,
    apellidos varchar(40) not null,
    contacto varchar(20) not null,
    salario int)    
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE Verduleria.unidades_medida (
	id_unidad_medida int not null auto_increment primary key, 
    nombre varchar(30) not null)    /* cajas o unid : unidades*/
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE Verduleria.producto(
	id_producto int not null auto_increment primary key,
    nombre varchar(50) not null,
    cantidad_disponible int,
    precio decimal(10,2),
    id_unidad_medida int,
    foreign key fk_unidad_medida (id_unidad_medida) references unidades_medida(id_unidad_medida)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE Verduleria.ventas(
	id_cajas int not null auto_increment primary key,
    nombre_cliente varchar(50) not null,
    cantidad_comprada int,
    total_compra decimal(10,2),
    id_producto int not null,
    foreign key fk_nombre_producto (id_producto) references producto(id_producto)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;


INSERT INTO Verduleria.usuarios (id_usuario, username, password) VALUES 
(1, 'user','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.');

INSERT INTO Verduleria.cargo (id_cargo, cargo, id_usuario) VALUES 
(1,'ROLE_ADMIN',1), (2,'ROLE_VENDEDOR',1);

INSERT INTO Verduleria.Empleado (id_empleado, nombre, apellidos, contacto, salario) VALUES 
(1, 'Carlos', 'Ruiz','8867-2345', '500000');

INSERT INTO Verduleria.unidades_medida VALUES
('1','Cajas'), ('2','Unid');

INSERT INTO Verduleria.producto (nombre, cantidad_disponible, precio, id_unidad_medida) VALUES 
('Zanahoria', 10, 1200, 1),
('Tomate', 25, 700, 1),
('Brocoli', 30, 1700, 2);