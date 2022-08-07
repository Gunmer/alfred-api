INSERT INTO shopping_lists (uuid) VALUES ('1');

INSERT INTO shopping_items (uuid, description, status, amount, shopping_list_uuid) VALUES ('1', 'Item', 'PENDING', 1, '1');
INSERT INTO shopping_items (uuid, description, status, amount, shopping_list_uuid) VALUES ('2', 'Item 2', 'PENDING', 1, '1');

INSERT INTO families (uuid, name, shopping_list_uuid) VALUES ( '1', 'Sosa Family', '1');

INSERT INTO users (uuid, name, family_name, family_uuid) VALUES ('1', 'Cristiam', 'Sosa', '1');
INSERT INTO users (uuid, name, family_name, family_uuid) VALUES ('2', 'Diego', 'Perez', null);
INSERT INTO users (uuid, name, family_name, family_uuid) VALUES ('3', 'Mika', 'Sosa', null);
