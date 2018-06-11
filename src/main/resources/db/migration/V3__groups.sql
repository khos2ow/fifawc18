CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT IGNORE INTO groups(uuid, name) VALUES(UUID(), "A");
INSERT IGNORE INTO groups(uuid, name) VALUES(UUID(), "B");
INSERT IGNORE INTO groups(uuid, name) VALUES(UUID(), "C");
INSERT IGNORE INTO groups(uuid, name) VALUES(UUID(), "D");
INSERT IGNORE INTO groups(uuid, name) VALUES(UUID(), "E");
INSERT IGNORE INTO groups(uuid, name) VALUES(UUID(), "F");
INSERT IGNORE INTO groups(uuid, name) VALUES(UUID(), "G");
INSERT IGNORE INTO groups(uuid, name) VALUES(UUID(), "H");
