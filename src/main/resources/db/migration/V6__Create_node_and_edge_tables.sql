CREATE TABLE nodes (
    id              INTEGER NOT NULL,
    label           VARCHAR NOT NULL,
    site			VARCHAR NOT NULL,
    PRIMARY KEY(id, site)
);

CREATE TABLE edges (
    id              INTEGER NOT NULL,
    source			INTEGER NOT NULL,
    target			INTEGER NOT NULL,
    site			VARCHAR NOT NULL,
    PRIMARY KEY(id, site)
);