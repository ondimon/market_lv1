drop table if exists products cascade;
drop table if exists categories cascade;
drop table if exists products_categories cascade;
create table products (id bigserial, title varchar(255), description varchar(5000), price int, primary key(id));
create table categories (id bigserial, title varchar(255));
create table products_categories (product_id bigserial, category_id bigserial);

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
