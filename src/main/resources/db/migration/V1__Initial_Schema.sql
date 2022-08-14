drop table if exists public.users;
create table if not exists public.users
(
    uuid        varchar(36) primary key not null,
    name        varchar(64)             not null,
    family_name varchar(64)             not null,
    family_uuid varchar(36)
);

drop table if exists public.families;
create table if not exists public.families
(
    uuid               varchar(36) primary key not null,
    name               varchar(64)             not null,
    shopping_list_uuid varchar(36)             not null
);

drop table if exists public.shopping_lists;
create table if not exists public.shopping_lists
(
    uuid varchar(36) primary key not null
);

drop table if exists public.shopping_items;
create table if not exists public.shopping_items
(
    uuid               varchar(36) primary key not null,
    description        varchar(255)            not null,
    status             varchar(16)             not null,
    amount             int4                    not null,
    shopping_list_uuid varchar(36)             not null
);
