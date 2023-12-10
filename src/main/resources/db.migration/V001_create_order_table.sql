CREATE TABLE orders (
                        order_id bigint not null auto_increment primary key,
                        customer_id bigint not null,
                        order_date timestamp not null
                        constraint fk_customer_order foreign key (customer_id) references customer(customer_id) on delete cascade,
                        );

CREATE SEQUENCE order_seq;
