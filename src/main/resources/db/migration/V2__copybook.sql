USE `handmade_atelie`;

CREATE TABLE IF NOT EXISTS `copy_books` (
    `id` VARCHAR(255) NOT NULL PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `description` VARCHAR(300) NOT NULL,
    `image_url` VARCHAR(200) NOT NULL,
    `price` DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS `copy_book_especifications` (
    `id` VARCHAR(255) NOT NULL PRIMARY KEY,
    `title` VARCHAR(100) NOT NULL,
    `content` VARCHAR(100) NOT NULL,
    `FK_copy_book_id` VARCHAR(255) NOT NULL,
    FOREIGN KEY (`FK_copy_book_id`) REFERENCES `copy_books` (`id`)
)