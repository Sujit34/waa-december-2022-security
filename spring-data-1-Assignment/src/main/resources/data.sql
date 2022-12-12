INSERT INTO category (name) VALUES ('Laptop'),('Phone');

INSERT INTO product (name, price, rating, category_id) VALUES
                                                           ('Macbook', 1000, 4, 1),
                                                           ('Acer', 700, 5, 1),
                                                           ('Pixel', 500, 5, 2),
                                                           ('Samsung', 300, 6, 2);


INSERT INTO users (email, first_name, last_name, password) VALUES
                                                                ('sujit.chanda@miu.edu',  'Sujit', 'Chanda','1234567890'),
                                                                ('kumar.chanda@miu.edu', 'Kumar', 'Chanda','0987654321');

INSERT INTO review (review_comment, product_id, user_id) VALUES
                                                      ('Great Product', 1, 2),
                                                      ('Nice One', 1, 1),
                                                      ('Bad Product',2,2);

INSERT INTO address (city, street, zip,user_id) VALUES
                                            ('FairField', '1000 N. 4th St.', '52557',1),
                                            ('Burlington', '1001 N. 5th St.', '52885' ,2);
INSERT INTO role (role) VALUES ('ADMIN'),('USER');

INSERT INTO role_users (roles_id, users_id) VALUES (1, 1), (2, 2);


