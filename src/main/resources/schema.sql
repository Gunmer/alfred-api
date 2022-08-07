CREATE TABLE IF NOT EXISTS users (
    uuid varchar(255) primary key not null,
    name varchar(255) not null,
    family_name varchar(255) not null,
    family_uuid varchar(255)
);

CREATE TABLE IF NOT EXISTS families (
  uuid varchar(255) primary key not null,
  name varchar(255) not null,
  shopping_list_uuid varchar(255) not null
);

CREATE TABLE IF NOT EXISTS shopping_lists (
    uuid varchar(255) primary key not null
);

CREATE TABLE IF NOT EXISTS shopping_items (
    uuid varchar(255) primary key not null,
    description varchar(255) not null,
    status varchar(255) not null,
    amount number not null,
    shopping_list_uuid varchar(255) not null
);
