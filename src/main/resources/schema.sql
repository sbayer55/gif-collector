--USE gif;

CREATE TABLE IF NOT EXISTS user (
    `id` INt NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50),
    `first_name` VARCHAR(50),
    `last_name` VARCHAR(50),
    PRIMARY KEY (`id`)
);