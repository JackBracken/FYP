CREATE TABLE posts (
    id              INTEGER NOT NULL,
    postTypeID      INTEGER NOT NULL,
    creationDate    TIMESTAMP WITHOUT TIME ZONE,
    score           INTEGER NOT NULL,
    acceptedAnswer  INTEGER,
    ownerID         INTEGER,
    answers         INTEGER
);
