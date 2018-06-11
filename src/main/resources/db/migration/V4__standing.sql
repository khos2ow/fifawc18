CREATE TABLE `standing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL,
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
  KEY `FK4awhvl2ehgj44wlnqswxkc5b7` (`group_id`),
  KEY `FKk0dfm7sbpoa92k84uygyb1iax` (`team_id`),
  CONSTRAINT `FK4awhvl2ehgj44wlnqswxkc5b7` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `FKk0dfm7sbpoa92k84uygyb1iax` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 1, 1, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 1, 8, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 1, 15, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 1, 22, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 2, 19, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 2, 11, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 2, 25, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 2, 3, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 3, 18, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 3, 31, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 3, 32, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 3, 30, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 4, 20, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 4, 16, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 4, 28, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 4, 12, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 5, 2, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 5, 27, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 5, 13, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 5, 17, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 6, 9, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 6, 5, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 6, 29, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 6, 7, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 7, 6, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 7, 20, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 7, 26, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 7, 10, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 8, 10, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 8, 20, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 8, 21, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT IGNORE INTO standing(uuid, group_id, team_id, games, wins, draws, loses, goals_for, goals_against, goals_diff, points) VALUES(UUID(), 8, 4, 0, 0, 0, 0, 0, 0, 0, 0);
