-- -----------------------------------------------------
-- Schema book-service
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `book-service`;

CREATE SCHEMA `book-service`;
USE `book-service` ;

-- -----------------------------------------------------
-- Table `book-service`.`book_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book-service`.`book_category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `book-service`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book-service`.`book` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `image_url` VARCHAR(255) DEFAULT NULL,
  `active` BIT DEFAULT 1,
  `units_in_stock` INT(11) DEFAULT NULL,
   `date_created` DATETIME(6) DEFAULT NULL,
  `last_updated` DATETIME(6) DEFAULT NULL,
  `category_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category` (`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `book_category` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------

INSERT INTO book_category(category_name) VALUES ('PROGRAMMING');

INSERT INTO book (name, description, image_url, active, units_in_stock,
category_id, date_created)
VALUES ('JavaScript - The Fun Parts', 'Learn JavaScript',
'assets/images/books/placeholder.png'
,1,100,1, NOW());

INSERT INTO book (name, description, image_url, active, units_in_stock,
category_id, date_created)
VALUES ('Spring Framework Tutorial', 'Learn Spring',
'assets/images/books/placeholder.png'
,1,100,1, NOW());

INSERT INTO book (name, description, image_url, active, units_in_stock,
category_id, date_created)
VALUES ('Kubernetes - Deploying Containers', 'Learn Kubernetes',
'assets/images/books/placeholder.png'
,1,100,1, NOW());
