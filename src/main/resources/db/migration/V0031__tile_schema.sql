CREATE TABLE tile (
  id BINARY(16) NOT NULL,
  biomes BINARY(9) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB CHARACTER SET=utf8mb4, COLLATE=utf8mb4_unicode_ci;

ALTER TABLE room ADD COLUMN tile BINARY(1);
