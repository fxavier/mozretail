CREATE TABLE category(
category_id BIGSERIAL NOT NULL,
name VARCHAR(100) NOT NULL,
PRIMARY KEY(category_id)
);

CREATE TABLE subcategory(
subcategory_id BIGSERIAL NOT NULL,
name VARCHAR(100) NOT NULL,
category_id BIGINT NOT NULL,
PRIMARY KEY(subcategory_id),
CONSTRAINT fk_subcategory_category
  FOREIGN KEY(category_id) REFERENCES category(category_id)
);

CREATE TABLE country(
country_id BIGSERIAL,
country_name VARCHAR(255) NOT NULL,
code CHAR(2) DEFAULT NULL,
PRIMARY KEY(country_id)
);

CREATE TABLE image(
image_id BIGSERIAL NOT NULL,
image_name VARCHAR(255),
image_url VARCHAR(500),
PRIMARY KEY(image_id)
);

CREATE TABLE color(
color_id BIGSERIAL NOT NULL,
color_name VARCHAR(100),
color_hexadesignation VARCHAR(250),
PRIMARY KEY(color_id)
);

CREATE TABLE size(
size_id BIGSERIAL NOT NULL,
size_designation VARCHAR(100),
PRIMARY KEY(size_id)
);

CREATE TABLE currency(
currency_id BIGSERIAL NOT NULL,
currency_name VARCHAR(100),
currency_code CHAR(3),
PRIMARY KEY(currency_id)
);

CREATE TABLE brand(
brand_id BIGSERIAL NOT NULL,
brand_name VARCHAR(255) NOT NULL,
PRIMARY KEY(brand_id)
);

CREATE TABLE product(
product_id BIGSERIAL NOT NULL,
product_name VARCHAR(250) NOT NULL,
product_description TEXT,
price NUMERIC(19, 2) NOT NULL DEFAULT 0,
subcategory_id BIGINT,
PRIMARY KEY(product_id),
CONSTRAINT fk_product_subcategory
  FOREIGN KEY(subcategory_id) REFERENCES subcategory(subcategory_id)
);

CREATE TABLE product_detail(
product_detail_id BIGSERIAL,
image_id BIGINT,
color_id BIGINT,
size_id BIGINT,
product_id BIGINT,
CONSTRAINT fk_product_detail_image
  FOREIGN KEY(image_id) REFERENCES image(image_id),
CONSTRAINT fk_product_details_color
  FOREIGN KEY(color_id) REFERENCES color(color_id),
CONSTRAINT fk_product_detail_size
  FOREIGN KEY(size_id) REFERENCES size(size_id),
CONSTRAINT fk_product_detail_product
   FOREIGN KEY(product_id) REFERENCES product(product_id)
);

