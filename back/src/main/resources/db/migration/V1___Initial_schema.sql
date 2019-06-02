CREATE TABLE IF NOT EXISTS offer(
    id serial PRIMARY KEY,
    title VARCHAR(32) NOT NULL,
    description VARCHAR(64) NOT NULL,
    location VARCHAR(32) NOT NULL,
    author VARCHAR(45) NOT NULL,
    creation_date VARCHAR(45) NOT NULL,
    available_date VARCHAR(45) NOT NULL
);