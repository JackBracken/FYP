CREATE TABLE questions (
    id                  INTEGER NOT NULL,
    ownerID             INTEGER NOT NULL,
    answers             INTEGER[] NOT NULL,
    site                VARCHAR NOT NULL,
    PRIMARY KEY(id, site)
);

CREATE TABLE ANSWERS (
    id                  INTEGER NOT NULL,
    ownerID             INTEGER NOT NULL,
    parentID            INTEGER NOT NULL,
    score               INTEGER NOT NULL,
    site                VARCHAR NOT NULL,
    PRIMARY KEY(id, site)
);
