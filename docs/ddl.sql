CREATE TABLE IF NOT EXISTS `Player`
(
    `player_id`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `team_id`    INTEGER                           NOT NULL,
    `jersey`     TEXT,
    `last_name`  TEXT,
    `first_name` TEXT,
    `position`   TEXT,
    `college`    TEXT,
    FOREIGN KEY (`team_id`) REFERENCES `Team` (`team_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX `index_Player_team_id` ON `Player` (`team_id`);

CREATE INDEX `index_Player_jersey` ON `Player` (`jersey`);

CREATE INDEX `index_Player_last_name` ON `Player` (`last_name`);

CREATE INDEX `index_Player_first_name` ON `Player` (`first_name`);

CREATE TABLE IF NOT EXISTS `Team`
(
    `team_id`      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `abbreviation` TEXT,
    `full_name`    TEXT,
    `short_name`   TEXT
);

CREATE UNIQUE INDEX `index_Team_abbreviation` ON `Team` (`abbreviation`);

CREATE UNIQUE INDEX `index_Team_full_name` ON `Team` (`full_name`);

CREATE UNIQUE INDEX `index_Team_short_name` ON `Team` (`short_name`);