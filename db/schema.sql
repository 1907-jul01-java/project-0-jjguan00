drop table if exists checkusers;
drop table if exists users;
drop table if exists transactions;
drop table if exists checks;
drop table if exists admins;

create table users (
  id serial primary key,
  username text not null unique,
  firstname text not null,
  password text not null
);

create table checks(
	id int primary key,
	balance int not null,
	approved boolean not null
);

create table transactions(
	id serial primary key,
	context text not null,
	checkid int not null,
	constraint checkid foreign key(checkid) references Checks(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE checkusers
(
userID INT NOT NULL, 
checkAccount INT NOT NULL,
PRIMARY KEY(userID, checkAccount),

constraint fk_checkuser__user
foreign key(userID) references Users(id),

constraint fk_checkuser__checkID
foreign key(checkAccount) references Checks(id)

);

create table admins(
	id serial primary key,
	adminname text not null,
	password text not null
);

INSERT INTO admins(adminname,password) VALUES ('admin','admin');
INSERT INTO checks values(11111, '1000', false);