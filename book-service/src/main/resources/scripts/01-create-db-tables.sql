-- -----------------------------------------------------
-- Schema book-service
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `book-service`;

CREATE SCHEMA `book-service`;
USE `book-service` ;

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
  `tags` VARCHAR(400) DEFAULT NULL,
   PRIMARY KEY (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------

INSERT INTO book (name, description, image_url, active, units_in_stock, tags, date_created)
VALUES ('JavaScript - The Fun Parts', 'Learn JavaScript',
'assets/images/books/placeholder.png'
,1,100,'programming, javascript', NOW());

INSERT INTO book (name, description, image_url, active, units_in_stock,
tags, date_created)
VALUES ('Spring Framework Tutorial', 'Learn Spring',
'assets/images/books/placeholder.png'
,1,100,'programming, java, spring', NOW());

INSERT INTO book (name, description, image_url, active, units_in_stock,
tags, date_created)
VALUES ('Kubernetes - Deploying Containers', 'Learn Kubernetes',
'assets/images/books/placeholder.png'
,1,100,'programming, kubernetes, devops', NOW());
