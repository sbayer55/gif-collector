DROP TABLE IF EXISTS application_user;
CREATE TABLE application_user (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(256),
    `password` VARCHAR(256),
    `first_name` VARCHAR(50),
    `last_name` VARCHAR(50),
    PRIMARY KEY (`id`)
);

--DROP TABLE IF EXISTS oauth_client_details;
--CREATE TABLE oauth_client_details (
--    `client_id` VARCHAR(256),
--    `resource_ids` VARCHAR(256),
--    `client_secret` VARCHAR(256),
--    `scope` VARCHAR(256),
--    `authorized_grant_types` VARCHAR(256),
--    `web_server_redirect_uri` VARCHAR(256),
--    `authorities` VARCHAR(256),
--    `access_token_validity` INTEGER,
--    `refresh_token_validity` INTEGER,
--    `additional_information` VARCHAR(4096),
--    `autoapprove` VARCHAR(256),
--    PRIMARY KEY (`client_id`)
--);
--
--DROP TABLE IF EXISTS oauth_client_token;
--CREATE TABLE oauth_client_token (
--    `token_id` VARCHAR(256),
--    `token` LONGVARBINARY,
--    `authentication_id` VARCHAR(256),
--    `user_name` VARCHAR(256),
--    `client_id` VARCHAR(256),
--    PRIMARY KEY (`authentication_id`)
--);
--
--DROP TABLE IF EXISTS oauth_access_token;
--CREATE TABLE oauth_access_token (
--    `token_id` VARCHAR(256),
--    `token` LONGVARBINARY,
--    `authentication_id` VARCHAR(256),
--    `user_name` VARCHAR(256),
--    `client_id` VARCHAR(256),
--    `authentication` LONGVARBINARY,
--    `refresh_token` VARCHAR(256),
--    PRIMARY KEY (`authentication_id`)
--);
--
--DROP TABLE IF EXISTS oauth_refresh_token;
--CREATE TABLE oauth_refresh_token (
--    `token_id` VARCHAR(256),
--    `token` LONGVARBINARY,
--    `authentication` LONGVARBINARY
--);
--
--DROP TABLE IF EXISTS oauth_code;
--CREATE TABLE oauth_code (
--    `code` VARCHAR(256),
--    `authentication` LONGVARBINARY
--);
--
--DROP TABLE IF EXISTS oauth_approvals;
--CREATE TABLE oauth_approvals (
--	`user_id` VARCHAR(256),
--	`client_id` VARCHAR(256),
--	`scope` VARCHAR(256),
--	`status` VARCHAR(10),
--	`expires_at` TIMESTAMP,
--	`last_modified_at` TIMESTAMP
--);

DROP TABLE IF EXISTS gif;
CREATE TABLE gif (
    `id` INT NOT NULL AUTO_INCREMENT,
    `owner_id` INT NOT NULL,
    `import_datetime` TIMESTAMP,
    `trending_datetime` TIMESTAMP,
    `title` VARCHAR(255),
    `fixed_height_url` VARCHAR(2083),
    `fixed_height_width` INT,
    `fixed_height_height` INT,
    `fixed_height_small_still_url` VARCHAR(2083),
    `fixed_height_small_still_width` INT,
    `fixed_height_small_still_height` INT,
    `original_url` VARCHAR(2083),
    `original_width` INT,
    `original_height` INT,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`owner_id`) REFERENCES application_user(`id`)
);

DROP TABLE IF EXISTS gif_tag;
CREATE TABLE gif_tag (
    `id` INT NOT NULL AUTO_INCREMENT,
    `gif_id` INT NOT NULL,
    `name` VARCHAR(255),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`gif_id`) REFERENCES gif(`id`)
);