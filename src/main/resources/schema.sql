CREATE TABLE IF NOT EXISTS employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO employee (name) VALUES ('Alice Johnson');
INSERT INTO employee (name) VALUES ('Bob Smith');
INSERT INTO employee (name) VALUES ('Charlie Davis');