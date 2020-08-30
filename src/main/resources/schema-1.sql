
drop table employee_addresses if exists
drop table address if exists
drop table employee if exists

/*
 * drop sequence if exists hibernate_sequence
 * create sequence hibernate_sequence start with 1 increment by 1
 */

create table address (id integer not null auto_increment, hno integer not null, pincode integer not null, street varchar(255), primary key (id))
create table employee (id integer not null auto_increment, age integer not null, name varchar(255), primary key (id))
create table employee_addresses (employee_id integer not null auto_increment, addresses_id integer not null)

alter table employee_addresses add constraint UK_psvtecwfwprmxj4c8sf1057ut unique (addresses_id)
alter table employee_addresses add constraint FKh2yku498btgqo0m3cci8l36f4 foreign key (addresses_id) references address
alter table employee_addresses add constraint FKk9tk9o1fymv1wq2fuycf5i040 foreign key (employee_id) references employee