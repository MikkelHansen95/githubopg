-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cupcake
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cupcake` DEFAULT CHARACTER SET utf8 ;
USE `cupcake` ;

-- -----------------------------------------------------
-- Table `cupcake`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `balance` DECIMAL(10,2) UNSIGNED NOT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `users_user_id` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_orders_users1_idx` (`users_user_id` ASC),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_user_id`)
    REFERENCES `cupcake`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`bottoms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`bottoms` (
  `bottom_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) UNSIGNED NOT NULL,
  PRIMARY KEY (`bottom_id`))
ENGINE = InnoDB;

INSERT INTO bottoms (name,price) VALUE
('Chocolate',5.00),
('Vanilla',5.00),
('Nutmeg',6.00),
('Pistacio',6.00),
('Almond',7.00);

-- -----------------------------------------------------
-- Table `cupcake`.`toppings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`toppings` (
  `topping_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) UNSIGNED NOT NULL,
  PRIMARY KEY (`topping_id`))
ENGINE = InnoDB;

INSERT INTO toppings (name,price) VALUE
('Chocolate',5.00),
('Blueberry',5.00),
('Rasberry',5.00),
('Crispy',6.00),
('Strawberry',6.00),
('Rum/Raisin',7.00),
('Orange',8.00),
('Lemon',8.00),
('Blue cheese',9.00);

-- -----------------------------------------------------
-- Table `cupcake`.`orderlines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`orderlines` (
  `orderline_id` INT NOT NULL AUTO_INCREMENT,
  `price` DECIMAL UNSIGNED NOT NULL,
  `bottoms_bottom_id` INT NOT NULL,
  `toppings_topping_id` INT NOT NULL,
  PRIMARY KEY (`orderline_id`),
  INDEX `fk_orderlines_bottoms1_idx` (`bottoms_bottom_id` ASC),
  INDEX `fk_orderlines_toppings1_idx` (`toppings_topping_id` ASC),
  CONSTRAINT `fk_orderlines_bottoms1`
    FOREIGN KEY (`bottoms_bottom_id`)
    REFERENCES `cupcake`.`bottoms` (`bottom_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderlines_toppings1`
    FOREIGN KEY (`toppings_topping_id`)
    REFERENCES `cupcake`.`toppings` (`topping_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cupcake`.`orderdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`orderdetails` (
  `orders_order_id` INT NOT NULL,
  `orderlines_orderline_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`orders_order_id`, `orderlines_orderline_id`),
  INDEX `fk_orderdetails_orders1_idx` (`orders_order_id` ASC),
  CONSTRAINT `fk_orderdetails_orderlines1`
    FOREIGN KEY (`orderlines_orderline_id`)
    REFERENCES `cupcake`.`orderlines` (`orderline_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderdetails_orders1`
    FOREIGN KEY (`orders_order_id`)
    REFERENCES `cupcake`.`orders` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
