CREATE DATABASE LABS_KPP;

USE LABS_KPP;

CREATE TABLE car_type
(
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    CONSTRAINT pk_id PRIMARY KEY(id)
);

CREATE TABLE car_color(
    id BIGINT AUTO_INCREMENT,
    color VARCHAR(100),
    CONSTRAINT pk_id PRIMARY KEY (id)
);

CREATE TABLE car
(
    id BIGINT AUTO_INCREMENT,
    type_id BIGINT,
    max_speed DOUBLE NOT NULL,
    count_seat_places INT NOT NULL,
    load_capacity DOUBLE NOT NULL,
    color_id BIGINT,
    CONSTRAINT pk_id PRIMARY KEY (id),
    CONSTRAINT fk_car_type FOREIGN KEY (type_id) REFERENCES car_type(id),
    CONSTRAINT fk_car_color FOREIGN KEY (color_id) REFERENCES car_color(id)
);

SELECT c.id, col.color, tp.name, c.max_speed, c.count_seat_places, c.load_capacity
       FROM car c
           INNER JOIN car_type tp
               on c.type_id = tp.id
           INNER JOIN car_color col
               on col.id = c.color_id;