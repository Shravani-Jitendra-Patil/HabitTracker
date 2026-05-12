CREATE DATABASE IF NOT EXISTS habit_tracker_db;
USE habit_tracker_db;

CREATE TABLE IF NOT EXISTS habits (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    habit_name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    frequency VARCHAR(30) NOT NULL,
    created_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS habit_logs (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    habit_id BIGINT NOT NULL,
    log_date DATE NOT NULL,
    completed BOOLEAN NOT NULL,
    CONSTRAINT fk_habit_logs_habit FOREIGN KEY (habit_id) REFERENCES habits(id) ON DELETE CASCADE,
    CONSTRAINT uk_habit_log UNIQUE (habit_id, log_date)
);
