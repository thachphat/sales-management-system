# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table customer (
  CUSTOMER_ID               bigint not null,
  name                      varchar(255),
  address                   varchar(255),
  phone1                    varchar(255),
  phone2                    varchar(255),
  email1                    varchar(255),
  email2                    varchar(255),
  constraint pk_customer primary key (CUSTOMER_ID))
;

create table customer_transaction (
  internal_id               bigint not null,
  sell_date                 date,
  price                     integer,
  is_paid                   boolean,
  quantity                  integer,
  customer_CUSTOMER_ID      bigint,
  product_id                bigint,
  constraint pk_customer_transaction primary key (internal_id))
;

create table product (
  id                        bigint not null,
  ean                       varchar(255) not null,
  name                      varchar(255),
  description               varchar(255),
  instock                   integer not null,
  constraint uq_product_ean unique (ean),
  constraint pk_product primary key (id))
;

create table supplier (
  SUPPLIER_ID               bigint not null,
  address                   varchar(255),
  phone1                    varchar(255),
  phone2                    varchar(255),
  email1                    varchar(255),
  email2                    varchar(255),
  name                      varchar(255) not null,
  constraint uq_supplier_name unique (name),
  constraint pk_supplier primary key (SUPPLIER_ID))
;

create table supplier_transaction (
  internal_id               bigint not null,
  buy_date                  varchar(255),
  quantity                  integer not null,
  price                     integer not null,
  is_paid                   boolean not null,
  SUPPLIER_ID               bigint,
  ean                       bigint,
  constraint pk_supplier_transaction primary key (internal_id))
;

create table user (
  username                  varchar(255) not null,
  password                  varchar(255),
  constraint pk_user primary key (username))
;

create table user_action (
  id                        bigint not null,
  description               varchar(255) not null,
  verb                      varchar(255) not null,
  create_date               timestamp,
  constraint uq_user_action_description unique (description),
  constraint pk_user_action primary key (id))
;

create sequence customer_seq;

create sequence customer_transaction_seq;

create sequence product_seq;

create sequence supplier_seq;

create sequence supplier_transaction_seq;

create sequence user_seq;

create sequence user_action_seq;

alter table customer_transaction add constraint fk_customer_transaction_custom_1 foreign key (customer_CUSTOMER_ID) references customer (CUSTOMER_ID) on delete restrict on update restrict;
create index ix_customer_transaction_custom_1 on customer_transaction (customer_CUSTOMER_ID);
alter table customer_transaction add constraint fk_customer_transaction_produc_2 foreign key (product_id) references product (id) on delete restrict on update restrict;
create index ix_customer_transaction_produc_2 on customer_transaction (product_id);
alter table supplier_transaction add constraint fk_supplier_transaction_suppli_3 foreign key (SUPPLIER_ID) references supplier (SUPPLIER_ID) on delete restrict on update restrict;
create index ix_supplier_transaction_suppli_3 on supplier_transaction (SUPPLIER_ID);
alter table supplier_transaction add constraint fk_supplier_transaction_produc_4 foreign key (ean) references product (id) on delete restrict on update restrict;
create index ix_supplier_transaction_produc_4 on supplier_transaction (ean);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists customer;

drop table if exists customer_transaction;

drop table if exists product;

drop table if exists supplier;

drop table if exists supplier_transaction;

drop table if exists user;

drop table if exists user_action;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists customer_seq;

drop sequence if exists customer_transaction_seq;

drop sequence if exists product_seq;

drop sequence if exists supplier_seq;

drop sequence if exists supplier_transaction_seq;

drop sequence if exists user_seq;

drop sequence if exists user_action_seq;

