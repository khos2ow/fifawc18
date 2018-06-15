CREATE TABLE `predictions_standing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `games` int(11) DEFAULT NULL,
  `wins` int(11) DEFAULT NULL,
  `draws` int(11) DEFAULT NULL,
  `loses` int(11) DEFAULT NULL,
  `goals_for` int(11) DEFAULT NULL,
  `goals_against` int(11) DEFAULT NULL,
  `goals_diff` int(11) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2jaj2eu9amaarxavnqywrfntg` (`group_id`),
  KEY `FKtfjmbqyvtih5k1kf8c9c02um3` (`team_id`),
  KEY `FKk00e3s7hw16td5q4iewy8g3uq` (`user_id`),
  CONSTRAINT `FK2jaj2eu9amaarxavnqywrfntg` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `FKk00e3s7hw16td5q4iewy8g3uq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKtfjmbqyvtih5k1kf8c9c02um3` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `predictions`;


CREATE TABLE `predictions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `stage` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `team_1_id` int(11) DEFAULT NULL,
  `team1_indicator` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `team1_goals` int(11) DEFAULT NULL,
  `team1_penalty_goals` int(11) DEFAULT NULL,
  `team_2_id` int(11) DEFAULT NULL,
  `team2_indicator` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `team2_goals` int(11) DEFAULT NULL,
  `team2_penalty_goals` int(11) DEFAULT NULL,
  `match_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5ehjwkl57ibsn56fjmwj892ju` (`user_id`),
  KEY `FKoxhvb55cthy2db8chg8wjueif` (`group_id`),
  KEY `FKcb3dla0ubmbj7b80erjd92kwo` (`team_1_id`),
  KEY `FK732qceyut5s5ld0wifvwba7wd` (`team_2_id`),
  CONSTRAINT `FK5ehjwkl57ibsn56fjmwj892ju` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK732qceyut5s5ld0wifvwba7wd` FOREIGN KEY (`team_2_id`) REFERENCES `team` (`id`),
  CONSTRAINT `FKcb3dla0ubmbj7b80erjd92kwo` FOREIGN KEY (`team_1_id`) REFERENCES `team` (`id`),
  CONSTRAINT `FKoxhvb55cthy2db8chg8wjueif` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
