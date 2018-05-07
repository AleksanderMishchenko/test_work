CREATE TABLE `products` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar NOT NULL,
	`type` varchar NOT NULL,
	`price` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `product_order` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`order_id` INT NOT NULL,
	`product_id` INT NOT NULL,
	`amount` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `orders` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`сlient_id` INT NOT NULL,
	`order_state_id` INT NOT NULL,
	`delivery_type` varchar NOT NULL,
	`payment_type` varchar NOT NULL,
	`order_date` DATETIME NOT NULL,
	`order_price` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `сlients` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar NOT NULL AUTO_INCREMENT,
	`address` varchar NOT NULL,
	`email` varchar NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `order_state` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `product_order` ADD CONSTRAINT `product_order_fk0` FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`);

ALTER TABLE `product_order` ADD CONSTRAINT `product_order_fk1` FOREIGN KEY (`product_id`) REFERENCES `products`(`id`);

ALTER TABLE `orders` ADD CONSTRAINT `orders_fk0` FOREIGN KEY (`сlient_id`) REFERENCES `сlients`(`id`);

ALTER TABLE `orders` ADD CONSTRAINT `orders_fk1` FOREIGN KEY (`order_state_id`) REFERENCES `order_state`(`id`);

