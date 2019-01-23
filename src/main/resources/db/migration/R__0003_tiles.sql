-- "Complete" tileset of 2-corner tiles
-- See http://www.cr31.co.uk/stagecast/wang/2corn.html under "Terrain Tilesets"

INSERT INTO tile (id, biomes) VALUES (uuid_bin('870d0f21-5d7f-4250-bb13-1c9760d0131d'), unhex('000000000000000000'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('2e2b9fca-344d-4666-8107-317a657b7e66'), unhex('000001000000000000'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('363ab86e-d116-472c-884a-a73ed53e5473'), unhex('000000000000000001'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('b1f9dba1-b660-4e42-8ed5-1d1195a3d444'), unhex('000001000001000001'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('91ebca3e-cd82-424a-9abb-4f46401b0026'), unhex('000000000000010000'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('449f173d-5720-4888-bb46-bc8ba11d0237'), unhex('000001000000010000'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('d9198f1e-1bdc-43f2-a75a-69ae145a2e75'), unhex('000000000000010101'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('3d09e68d-14c5-4a08-92f7-e326fe03f0dc'), unhex('000001000001010101'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('c723cc3f-5997-4877-856b-710a17bc8550'), unhex('010000000000000000'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('cb00179f-7355-452d-bf4c-d0db880aab6c'), unhex('010100000000000000'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('614d5744-c86b-445e-a425-1db9ab6b79e2'), unhex('010000000000000001'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('c263c2ef-4fb8-4f04-8e24-caf609379608'), unhex('010101010101000101'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('cd0ab1bd-8a2b-4b1a-9624-9c45361e2e14'), unhex('010000010000010000'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('23ef3e8a-06e6-4ca9-917f-0504ec6c39d5'), unhex('010101010101010100'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('ccc82a43-ba00-4517-9cff-7ae18685ab24'), unhex('010100010101010101'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);

INSERT INTO tile (id, biomes) VALUES (uuid_bin('016f205b-c069-4a89-a206-9495c2becabd'), unhex('010101010101010101'))
ON DUPLICATE KEY UPDATE biomes=VALUES(biomes);
