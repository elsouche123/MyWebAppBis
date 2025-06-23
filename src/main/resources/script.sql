CREATE TABLE annonce (
    id SERIAL PRIMARY KEY,
    title VARCHAR(64),
    description VARCHAR(256),
    adress VARCHAR(64),
    mail VARCHAR(64),
    date TIMESTAMP
);