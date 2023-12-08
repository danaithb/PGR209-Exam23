create table customer(
    customer_id bigint not null auto_increment primary key,
    customer_name varchar(100) not null,
    customer_email varchar(100) not null
);

create sequence customer_seq;