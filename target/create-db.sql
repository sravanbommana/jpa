create table Professor (id bigint not null, firstName varchar(255), lastName varchar(255), primary key (id)) engine=InnoDB;
create table Professor (id bigint not null, firstName varchar(255), lastName varchar(255), primary key (id)) engine=InnoDB;
create table Professor (id bigint not null, firstName varchar(255), lastName varchar(255), primary key (id)) engine=InnoDB;
create table Professor (id bigint not null, firstName varchar(255), lastName varchar(255), primary key (id)) engine=InnoDB;

    create table Professor (
        id bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table Professor (
        id integer not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table Professor (
        id integer not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table OrderItem (
        id integer not null,
        article varchar(255),
        quantity varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table Professor (
        id integer not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table PurchaseOrder (
        amount float(53) not null,
        id integer not null,
        customername varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table OrderItem (
        id integer not null,
        article varchar(255),
        quantity varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table Professor (
        id integer not null,
        firstName varchar(255),
        lastName varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table PurchaseOrder (
        amount float(53) not null,
        id integer not null,
        customername varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table PurchaseOrder (
        amount float(53) not null,
        id integer not null,
        customername varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table PurchaseOrder_SEQ (
        next_val bigint
    ) engine=InnoDB;

    insert into PurchaseOrder_SEQ values ( 1 );

    create table PurchaseOrder (
        amount float(53) not null,
        id integer not null,
        customername varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table PurchaseOrder_SEQ (
        next_val bigint
    ) engine=InnoDB;

    insert into PurchaseOrder_SEQ values ( 1 );

    create table PurchaseOrder (
        amount float(53) not null,
        id integer not null auto_increment,
        customername varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table PurchaseOrder (
        amount float(53) not null,
        id integer not null,
        customername varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table purchaseorder_sequence (
        next_val bigint
    ) engine=InnoDB;

    insert into purchaseorder_sequence values ( 1 );

    create table order_table (
        next_val bigint,
        sequence_name varchar(255) not null,
        primary key (sequence_name)
    ) engine=InnoDB;

    insert into order_table(sequence_name, next_val) values ('PurchaseOrder',0);

    create table PurchaseOrder (
        amount float(53) not null,
        id integer not null,
        customername varchar(255),
        primary key (id)
    ) engine=InnoDB;
