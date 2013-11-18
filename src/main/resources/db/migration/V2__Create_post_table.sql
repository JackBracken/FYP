CREATE TABLE posts (
    id              INTEGER NOT NULL,
    postTypeID      INTEGER NOT NULL,
    creationDate    TIMESTAMP WITHOUT TIME ZONE,
    score           INTEGER NOT NULL,
    body            VARCHAR NOT NULL,
    title           VARCHAR NOT NULL,
    tags            VARCHAR NOT NULL,
    acceptedID      INTEGER,
    ownerUserID     INTEGER,
    answerCount     INTEGER,
    favoriteCount   INTEGER
);
