create table customer (
          id  integer  unsigned not null auto_increment primary key
          references  product(id),
          name varchar(20) not null,
          email varchar (20) ,
          phone varchar (20) ,
          password varchar (10) not null

);

create table product (
        id integer unsigned not null auto_increment primary key
        references customer(id),
        name_product varchar (100) not null,
        final_price double (10,0) not null





);



create table role (
id integer not null auto_increment primary key,
name varchar (100) not null


);

create table custom_roles
(
    customer_id integer not null references role (id),
    roles_id    integer not null references customer (id),
      primary key auto_increment
    (customer_id,
    roles_id)
);






