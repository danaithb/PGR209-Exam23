create table address(
                        address_id bigint not null auto_increment primary key,
                        street varchar(100) not null,
                        city varchar(100) not null,
                        zip_code varchar(100) not null,
                        customer_id bigint not null,
                        constraint fk_customer foreign key (customer_id) references customer(customer_id) on delete cascade



);

create sequence address_seq;