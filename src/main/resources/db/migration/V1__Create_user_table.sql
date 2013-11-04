CREATE TABLE users (
    id              INTEGER NOT NULL,
    name            VARCHAR(30) NOT NULL,
    reputation      INTEGER NOT NULL,
    creationDate    TIMESTAMP WITHOUT TIME ZONE,
    displayName     VARCHAR(30) NOT NULL,
    lastAccess      TIMESTAMP WITHOUT TIME ZONE,
    location        VARCHAR(120),
    aboutText       VARCHAR,
    views           INTEGER NOT NULL,
    upVotes         INTEGER NOT NULL,
    downVotes       INTEGER NOT NULL,
    emailHash       VARCHAR,
    age             INTEGER
);
