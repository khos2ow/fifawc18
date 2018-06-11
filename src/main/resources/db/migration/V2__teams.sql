CREATE TABLE `team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `fifa_rank` int(11) DEFAULT NULL,
  `fifa_score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqv6wvrq3qclb3gvo92gg2y6q7` (`country_id`),
  CONSTRAINT `FKqv6wvrq3qclb3gvo92gg2y6q7` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 180, 70, 457);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 31, 2, 1431);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 102, 37, 708);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 109, 61, 521);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 141, 15, 989);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 22, 3, 1298);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 116, 57, 1298);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 192, 67, 465);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 81, 1, 1558);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 65, 12, 1051);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 206, 10, 1126);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 159, 48, 618);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 52, 23, 884);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 174, 8, 1183);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 63, 45, 649);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 99, 22, 908);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 195, 34, 751);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 74, 7, 1198);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 175, 4, 1274);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 11, 5, 1241);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 48, 16, 986);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 233, 14, 1018);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 168, 55, 571);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 194, 27, 838);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 148, 41, 686);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 223, 21, 910);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 213, 6, 1199);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 54, 20, 945);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 212, 24, 880);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 58, 12, 1051);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 14, 36, 718);
INSERT IGNORE INTO team(uuid, country_id, fifa_rank, fifa_score) VALUES(UUID(), 171, 11, 1125);
