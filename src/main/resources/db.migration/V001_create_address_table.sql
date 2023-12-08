create table address(
                        addressId int not null auto_increment primary key,
                        street varchar(100) not null,
                        city varchar(100) not null,
                        zipcode varchar(100) not null
);

create sequence address_seq;