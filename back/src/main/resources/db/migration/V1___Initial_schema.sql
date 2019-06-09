CREATE TABLE IF NOT EXISTS offer(
    id serial PRIMARY KEY,
    title VARCHAR(32) NOT NULL,
    description VARCHAR(64) NOT NULL,
    location VARCHAR(32) NOT NULL,
    author VARCHAR(45) NOT NULL,
    creation_date VARCHAR(45) NOT NULL,
    available_date VARCHAR(45) NOT NULL
);
CREATE TABLE IF NOT EXISTS author(
    id serial PRIMARY KEY,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    phone VARCHAR(32) NOT NULL,
    review VARCHAR(45) NOT NULL
);