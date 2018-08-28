delete from users;
delete from customers;
delete from tours;
delete from orders;

INSERT INTO users (login, password, role)
VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'manager');
INSERT INTO users (login, password, role)
VALUES ('user1', '0a041b9462caa4a31bac3567e0b6e6fd9100787db2ab433d96f6d178cabfce90', 'customer');
INSERT INTO users (login, password, role)
VALUES ('user2', '6025d18fe48abd45168528f18a82e265dd98d421a7084aa09f61b341703901a3', 'customer');
INSERT INTO users (login, password, role)
VALUES ('user3', '5860faf02b6bc6222ba5aca523560f0e364ccd8b67bee486fe8bf7c01d492ccb', 'customer');
INSERT INTO users (login, password, role)
VALUES ('user4', '5269ef980de47819ba3d14340f4665262c41e933dc92c1a27dd5d01b047ac80e', 'customer');
INSERT INTO users (login, password, role)
VALUES ('user5', '5a39bead318f306939acb1d016647be2e38c6501c58367fdb3e9f52542aa2442', 'customer');

INSERT INTO customers (name, surname, vip, user_id)
VALUES ('Kirill', 'Velosipedov', true, 2);
INSERT INTO customers (name, surname, vip, user_id)
VALUES ('Dunya', 'Velosipedova', true, 3);
INSERT INTO customers (name, surname, vip, user_id)
VALUES ('Ivan', 'Dulin', true, 4);
INSERT INTO customers (name, surname, vip, user_id)
VALUES ('Steve', 'Smith', true, 5);
INSERT INTO customers (name, surname, vip, user_id)
VALUES ('Apu', 'Nahasapeemapetilon', true, 6);

INSERT INTO tours (name, price, hot, discount)
VALUES ('Tour1', 30000, true, 10);
INSERT INTO tours (name, price, hot, discount)
VALUES ('Tour2', 60000, true, 20);
INSERT INTO tours (name, price, hot, discount)
VALUES ('Tour3', 100000, false , 0);
INSERT INTO tours (name, price, hot, discount)
VALUES ('Tour4', 150000, false , 0);
INSERT INTO tours (name, price, hot, discount)
VALUES ('Tour5', 250000, false , 0);

INSERT INTO orders (customer_id, tour_id, paid)
VALUES (1, 3, true);
INSERT INTO orders (customer_id, tour_id, paid)
VALUES (1, 4, true);
INSERT INTO orders (customer_id, tour_id, paid)
VALUES (1, 5, true);
INSERT INTO orders (customer_id, tour_id, paid)
VALUES (2, 1, true);
INSERT INTO orders (customer_id, tour_id, paid)
VALUES (3, 2, false);
INSERT INTO orders (customer_id, tour_id, paid)
VALUES (4, 4, true);
INSERT INTO orders (customer_id, tour_id, paid)
VALUES (5, 5, true);
INSERT INTO orders (customer_id, tour_id, paid)
VALUES (1, 1, false);
INSERT INTO orders (customer_id, tour_id, paid)
VALUES (1, 2, false);
INSERT INTO orders (customer_id, tour_id, paid)
VALUES (2, 2, false);