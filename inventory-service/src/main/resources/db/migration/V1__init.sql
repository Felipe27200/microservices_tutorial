create table inventory
(
    id           bigint(20) not null auto_increment,
    sku_code varchar(255) DEFAULT NULL,
    quantity int(11) DEFAULT NULL,
    primary key (id)
) engine=InnoDB