
create schema if not exists crud;

create table if not exists crud.configuration (
    id SERIAL primary key
);

create table if not exists crud.feature (
    id SERIAL primary key,
    configuration_id int not null,
    value varchar(100),
    constraint fk_feature foreign key(configuration_id) references crud.configuration(id)
);
