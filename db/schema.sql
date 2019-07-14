drop table if exists users;

drop table if exists admins;

create table users (
  id serial primary key,
  username text not null unique,
  firstname text not null,
  license text not null,
  password text not null,
  status boolean not null
);

create table admins(
	id serial primary key,
	adminname text not null,
	password text not null
);

INSERT INTO admins(adminname,password) VALUES ('admin','admin');
