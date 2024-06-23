CREATE DATABASE IF NOT EXISTS `handmade_atelie`;
USE `handmade_atelie`;

CREATE TABLE IF NOT EXISTS `states` (
  `id` INT NOT NULL,
  `acronym` varchar(2) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `users` (
  `id` varchar(255) NOT NULL,
  `cpf` varchar(12) NOT NULL,
  `date_of_birth` datetime(6) NOT NULL,
  `email` varchar(100) NOT NULL,
  `gender` varchar(30) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7kqluf7wl0oxs7n90fpya03ss` (`cpf`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  CONSTRAINT `users_chk_1` CHECK ((`role` between 0 and 1))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `adresses` (
  `id` varchar(255) NOT NULL,
  `city` varchar(100) NOT NULL,
  `complement` varchar(100) DEFAULT NULL,
  `neighborhood` varchar(100) NOT NULL,
  `number` varchar(20) NOT NULL,
  `street` varchar(100) NOT NULL,
  `zip_code` varchar(9) NOT NULL,
  `FK_state_id` INT NOT NULL,
  `FK_user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1434c41yqt8u7uq21uyn886yg` (`FK_state_id`),
  KEY `FKreji6chbe6yr2pdg1uuvlq5it` (`FK_user_id`),
  CONSTRAINT `FK1434c41yqt8u7uq21uyn886yg` FOREIGN KEY (`FK_state_id`) REFERENCES `states` (`id`),
  CONSTRAINT `FKreji6chbe6yr2pdg1uuvlq5it` FOREIGN KEY (`FK_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `phone_numbers` (
  `id` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `FK_user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg077extnnxwv904qjw2kwinpg` (`FK_user_id`),
  CONSTRAINT `FKg077extnnxwv904qjw2kwinpg` FOREIGN KEY (`FK_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO states (id, name, acronym) VALUES 

(1, 'Acre', 'AC'),
(2, 'Alagoas', 'AL'),
(3, 'Amapá', 'AP'),
(4, 'Amazonas', 'AM'),
(5, 'Bahia', 'BA'),
(6, 'Ceará', 'CE'),
(7, 'Distrito Federal', 'DF'),
(8, 'Espírito Santo', 'ES'),
(9, 'Goiás', 'GO'),
(10, 'Maranhão', 'MA'),
(11, 'Mato Grosso', 'MT'),
(12, 'Mato Grosso do Sul', 'MS'),
(13, 'Minas Gerais', 'MG'),
(14, 'Pará', 'PA'),
(15, 'Paraíba', 'PB'),
(16, 'Paraná', 'PR'),
(17, 'Pernambuco', 'PE'),
(18, 'Piauí', 'PI'),
(19, 'Rio de Janeiro', 'RJ'),
(20, 'Rio Grande do Norte', 'RN'),
(21, 'Rio Grande do Sul', 'RS'),
(22, 'Rondônia', 'RO'),
(23, 'Roraima', 'RR'),
(24, 'Santa Catarina', 'SC'),
(25, 'São Paulo', 'SP'),
(26, 'Sergipe', 'SE'),
(27, 'Tocantins', 'TO');

