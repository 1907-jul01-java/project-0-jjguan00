drop table if exists users;

create table users (
  id serial primary key,
  username text not null,
  firstname text not null,
  license text not null,
  password text not null,
  status boolean not null
);
