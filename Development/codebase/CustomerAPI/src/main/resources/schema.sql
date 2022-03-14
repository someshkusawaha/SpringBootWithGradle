DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
id int not null primary key auto_increment,
first_name varchar(255) not null,
sur_name varchar(255) not null,
smoothie_preference varchar(255) not null,
mobile_number varchar(255) not null
); 