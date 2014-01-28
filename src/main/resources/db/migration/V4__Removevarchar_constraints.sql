ALTER TABLE users
    ALTER COLUMN name TYPE varchar,
    ALTER COLUMN site TYPE varchar;

ALTER TABLE posts
    ALTER COLUMN site TYPE varchar;
