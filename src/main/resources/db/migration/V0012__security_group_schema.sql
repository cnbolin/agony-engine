CREATE EXTENSION IF NOT EXISTS "citext";

create table groups (
  id SERIAL NOT NULL,
  group_name citext not null,
  primary key (id));

create table group_authorities (
  group_id int not null,
  authority varchar(50) not null,
  constraint fk_group_authorities_group foreign key(group_id) references groups(id));

create table group_members (
  id SERIAL NOT NULL,
  username varchar(50) not null,
  group_id int not null,
  primary key (id),
  constraint fk_group_members_group foreign key(group_id) references groups(id));
