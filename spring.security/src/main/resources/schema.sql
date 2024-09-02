create table if not exists spring.users(
id int not null primary key auto_increment,
username varchar(45) not null,
password varchar(45) not null,
enabled int not null
);


create table if not exists spring.authorities (
id int not null primary key auto_increment,
username varchar(45) not null,
authority varchar(45) not null,
);