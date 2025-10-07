create table orders
(
    id           bigint not null auto_increment,
    order_number varchar(255),
    price        decimal(38, 2),
    quantity     integer,
    sku_code     varchar(255),
    primary key (id)
);