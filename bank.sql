CREATE DATABASE bank;
USE bank;

CREATE TABLE `user` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `dob` DATE DEFAULT NULL,
    `first_name` varchar(20) DEFAULT NULL,
    `last_name` varchar(20) DEFAULT NULL,
    `middle_name` varchar(20) DEFAULT NULL,
    `mobile_no` varchar(15) DEFAULT NULL,
    CONSTRAINT user_id_pk PRIMARY KEY(id)
);

CREATE TABLE `account` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `balance` double DEFAULT 0,
   `card_limit` double DEFAULT NULL,
   `card_number` varchar(19) NOT NULL,
   `card_name` varchar(20) NOT NULL,
   `user_id` bigint,
   CONSTRAINT account_id_pk PRIMARY KEY(id),
   CONSTRAINT account_userid_fk FOREIGN KEY(user_id) REFERENCES USER(id)
);
