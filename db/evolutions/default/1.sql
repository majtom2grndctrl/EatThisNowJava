# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table food (
  id                        bigint not null,
  name                      varchar(255),
  eaten                     boolean,
  expiry                    timestamp,
  email                     varchar(255),
  constraint pk_food primary key (id))
;

create table user (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (email))
;

create sequence food_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists food;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists food_seq;

drop sequence if exists user_seq;

