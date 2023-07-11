INSERT INTO profile_type (id, profile_type_enum) VALUES (1, 'CAR');

INSERT INTO profile (id, profile_type_id) VALUES (1, 1);

INSERT INTO layout (id, name, profile_id) VALUES (2, 'My simple layout', 1);

INSERT INTO product (id, name, supplier) VALUES (1, 'Lamp', 'Sun');

INSERT INTO product_part (id, name, serial_number, product_id) VALUES (1, 'Shade', 'AA123FR', 1);
INSERT INTO product_part (id, name, serial_number, product_id) VALUES (2, 'Bulb', 'BF43944', 1);
INSERT INTO product_part (id, name, serial_number, product_id) VALUES (3, 'Cable', 'KF84324', 1);

INSERT INTO layout_product (id, layout_id, product_id) VALUES (1, 2, 1);