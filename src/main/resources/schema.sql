CREATE TABLE IF NOT EXISTS users (
    uuid varchar(255) primary key not null,
    name varchar(255) not null,
    family_name varchar(255) not null,
    family_uuid varchar(255)
);

CREATE TABLE IF NOT EXISTS families (
  uuid varchar(255) primary key not null,
  name varchar(255) not null
);
