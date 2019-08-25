CREATE DATABASE szkola_programowania
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

CREATE TABLE user_group (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    user_group_id INT,
    FOREIGN KEY (user_group_id) REFERENCES user_group(id)
);

CREATE TABLE exercise (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    description TEXT
);

CREATE TABLE solution (
    id INT PRIMARY KEY AUTO_INCREMENT,
    created DATE,
    updated DATE,
    description TEXT,
    exercise_id INT,
    users_id INT,
    FOREIGN KEY (exercise_id) REFERENCES exercise(id),
    FOREIGN KEY (users_id) REFERENCES users(id)
);