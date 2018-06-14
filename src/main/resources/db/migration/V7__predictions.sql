CREATE TABLE `predictions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `team1_goals` int(11) DEFAULT NULL,
  `team1_penalty_goals` int(11) DEFAULT NULL,
  `team2_goals` int(11) DEFAULT NULL,
  `team2_penalty_goals` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5ehjwkl57ibsn56fjmwj892ju` (`user_id`),
  CONSTRAINT `FK5ehjwkl57ibsn56fjmwj892ju` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
