drop table if exists checkaccounts;


create table checkaccounts (
  id serial primary key,
  firstname text not null,
  lastname text not null,
  license text not null
);
