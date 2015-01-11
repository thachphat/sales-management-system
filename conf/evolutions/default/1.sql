# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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
  name                      varchar(255) not null,
  constraint uq_supplier_name unique (name),
  constraint pk_supplier primary key (SUPPLIER_ID))
;

create table supplier_transaction (
  internal_id               bigint not null,
  SUPPLIER_ID               bigint,
  ean                       bigint,
  buy_date                  timestamp,
  quantity                  integer not null,
  is_paid                   boolean not null,
  constraint pk_supplier_transaction primary key (internal_id))
;

create sequence product_seq;

create sequence supplier_seq;

create sequence supplier_transaction_seq;

alter table supplier_transaction add constraint fk_supplier_transaction_suppli_1 foreign key (SUPPLIER_ID) references supplier (SUPPLIER_ID) on delete restrict on update restrict;
create index ix_supplier_transaction_suppli_1 on supplier_transaction (SUPPLIER_ID);
alter table supplier_transaction add constraint fk_supplier_transaction_produc_2 foreign key (ean) references product (id) on delete restrict on update restrict;
create index ix_supplier_transaction_produc_2 on supplier_transaction (ean);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists product;

drop table if exists supplier;

drop table if exists supplier_transaction;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists product_seq;

drop sequence if exists supplier_seq;

drop sequence if exists supplier_transaction_seq;

