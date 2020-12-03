drop table if exists products cascade;
drop table if exists categories cascade;
drop table if exists products_categories cascade;
drop table if exists users cascade;
drop table if exists roles cascade;
drop table if exists users_roles cascade;

create table products (id bigserial, title varchar(255), description varchar(5000), price int, primary key(id));
create table categories (id bigserial, title varchar(255));
create table products_categories (product_id bigserial, category_id bigserial);
create table users (
  id                    bigserial,
  username              varchar(30) not null,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  locked                boolean,
  primary key (id)
);

create table roles (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);

CREATE TABLE users_roles (
  user_id               bigint not null,
  role_id               int not null,
  primary key (user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);

insert into products
(id, title, description, price) values
(1, 'Cheese', 'Fresh cheese', 320),
(2, 'Milk', 'Fresh milk', 80),
(3, 'Apples', 'Fresh apples', 80),
(4, 'Bread', 'Fresh bread', 30),
(5, 'A1', '', 1),
(6, 'A2', '', 2),
(7, 'A3', '', 3),
(8, 'A4', '', 4),
(9, 'A5', '', 5),
(10, 'A6', '', 6),
(11, 'A7', '', 7),
(12, 'A8', '', 8),
(13, 'A9', '', 9),
(14, 'A10', '', 10),
(15, 'A11', '', 11),
(16, 'A12', '', 12),
(17, 'A13', '', 13),
(18, 'A14', '', 14),
(19, 'A15', '', 15),
(20, 'A16', '', 16),
(21, 'A17', '', 17),
(22, 'A18', '', 18),
(23, 'A19', '', 19),
(24, 'A20', '', 20);

insert into categories (id, title) values
(1, 'food'),
(2, 'A'),
(3, 'fruit');

insert into products_categories (product_id, category_id) values
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(3, 3),
(5, 2),
(6, 2),
(7, 2);


insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, email, locked)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com', false),
('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin@gmail.com', false),
('userlocked', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'userlocked@gmail.com', true);

insert into users_roles (user_id, role_id) values (1, 1), (2, 1), (2, 2);
