CREATE TABLE `matches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL,
  `number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `stage` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `team_1_id` int(11) DEFAULT NULL,
  `team1_indicator` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `team1_goals` int(11) DEFAULT NULL,
  `team_2_id` int(11) DEFAULT NULL,
  `team2_indicator` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `team2_goals` int(11) DEFAULT NULL,
  `match_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKek7ipbtyb039qele24mub8a15` (`group_id`),
  KEY `FKo5m6m0xhr705rl3rupxepn37h` (`team_1_id`),
  KEY `FKt749vl43eq9wdl8sfuuegfwrw` (`team_2_id`),
  CONSTRAINT `FKek7ipbtyb039qele24mub8a15` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `FKo5m6m0xhr705rl3rupxepn37h` FOREIGN KEY (`team_1_id`) REFERENCES `team` (`id`),
  CONSTRAINT `FKt749vl43eq9wdl8sfuuegfwrw` FOREIGN KEY (`team_2_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "1", 0, 1, 1, null, null, 8, null, null, '2018-06-14 11:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "2", 0, 1, 15, null, null, 22, null, null, '2018-06-15 08:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "3", 0, 2, 25, null, null, 3, null, null, '2018-06-15 11:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "4", 0, 2, 19, null, null, 11, null, null, '2018-06-15 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "5", 0, 3, 18, null, null, 31, null, null, '2018-06-16 06:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "6", 0, 4, 20, null, null, 16, null, null, '2018-06-16 09:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "7", 0, 3, 32, null, null, 30, null, null, '2018-06-16 12:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "8", 0, 4, 28, null, null, 12, null, null, '2018-06-16 15:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "9", 0, 5, 13, null, null, 17, null, null, '2018-06-17 08:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "10", 0, 6, 9, null, null, 5, null, null, '2018-06-17 11:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "11", 0, 5, 2, null, null, 27, null, null, '2018-06-17 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "12", 0, 6, 29, null, null, 7, null, null, '2018-06-18 08:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "13", 0, 7, 6, null, null, 23, null, null, '2018-06-18 11:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "14", 0, 7, 26, null, null, 10, null, null, '2018-06-18 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "15", 0, 8, 21, null, null, 4, null, null, '2018-06-19 08:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "16", 0, 8, 14, null, null, 24, null, null, '2018-06-19 11:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "17", 0, 1, 1, null, null, 15, null, null, '2018-06-19 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "18", 0, 2, 19, null, null, 25, null, null, '2018-06-20 08:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "19", 0, 1, 22, null, null, 8, null, null, '2018-06-20 11:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "20", 0, 2, 3, null, null, 11, null, null, '2018-06-20 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "21", 0, 3, 30, null, null, 31, null, null, '2018-06-21 08:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "22", 0, 3, 18, null, null, 32, null, null, '2018-06-21 11:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "23", 0, 4, 20, null, null, 28, null, null, '2018-06-21 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "24", 0, 5, 2, null, null, 13, null, null, '2018-06-22 08:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "25", 0, 4, 12, null, null, 16, null, null, '2018-06-22 11:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "26", 0, 5, 17, null, null, 27, null, null, '2018-06-22 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "27", 0, 6, 6, null, null, 26, null, null, '2018-06-23 08:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "28", 0, 7, 7, null, null, 5, null, null, '2018-06-23 11:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "29", 0, 6, 9, null, null, 29, null, null, '2018-06-23 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "30", 0, 7, 10, null, null, 23, null, null, '2018-06-24 08:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "31", 0, 8, 4, null, null, 24, null, null, '2018-06-24 11:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "32", 0, 8, 14, null, null, 21, null, null, '2018-06-24 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "33", 0, 1, 22, null, null, 1, null, null, '2018-06-25 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "34", 0, 1, 8, null, null, 15, null, null, '2018-06-25 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "35", 0, 2, 11, null, null, 25, null, null, '2018-06-25 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "36", 0, 2, 3, null, null, 19, null, null, '2018-06-25 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "37", 0, 3, 31, null, null, 32, null, null, '2018-06-26 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "38", 0, 3, 30, null, null, 18, null, null, '2018-06-26 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "39", 0, 4, 12, null, null, 20, null, null, '2018-06-26 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "40", 0, 4, 16, null, null, 28, null, null, '2018-06-26 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "41", 0, 6, 7, null, null, 9, null, null, '2018-06-27 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "42", 0, 6, 5, null, null, 29, null, null, '2018-06-27 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "43", 0, 5, 17, null, null, 2, null, null, '2018-06-27 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "44", 0, 5, 27, null, null, 13, null, null, '2018-06-27 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "45", 0, 8, 4, null, null, 14, null, null, '2018-06-28 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "46", 0, 8, 24, null, null, 21, null, null, '2018-06-28 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "47", 0, 7, 23, null, null, 26, null, null, '2018-06-28 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "48", 0, 7, 10, null, null, 6, null, null, '2018-06-28 14:00:00');

INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "49", 1, null, null, "1C", null, null, "2D", null, '2018-06-30 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "50", 1, null, null, "1A", null, null, "2B", null, '2018-06-30 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "51", 1, null, null, "1B", null, null, "2A", null, '2018-07-01 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "52", 1, null, null, "1D", null, null, "2C", null, '2018-07-01 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "53", 1, null, null, "1E", null, null, "2F", null, '2018-07-02 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "54", 1, null, null, "1G", null, null, "2H", null, '2018-07-02 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "55", 1, null, null, "1F", null, null, "2E", null, '2018-07-03 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "56", 1, null, null, "1H", null, null, "2G", null, '2018-07-03 14:00:00');

INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "57", 2, null, null, "W49", null, null, "W50", null, '2018-07-06 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "58", 2, null, null, "W53", null, null, "W54", null, '2018-07-06 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "59", 2, null, null, "W55", null, null, "W56", null, '2018-07-07 10:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "60", 2, null, null, "W51", null, null, "W52", null, '2018-07-07 14:00:00');

INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "61", 3, null, null, "W57", null, null, "W58", null, '2018-07-10 14:00:00');
INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "62", 3, null, null, "W59", null, null, "W60", null, '2018-07-11 14:00:00');

INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "63", 4, null, null, "L61", null, null, "L62", null, '2018-07-14 10:00:00');

INSERT IGNORE INTO matches(uuid, number, stage, group_id, team_1_id, team1_indicator, team1_goals, team_2_id, team2_indicator, team2_goals, match_date) VALUES(UUID(), "64", 5, null, null, "W61", null, null, "W62", null, '2018-07-15 11:00:00');
