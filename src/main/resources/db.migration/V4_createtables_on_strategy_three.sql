CREATE TABLE test_strategy_three.person(
    person_id BIGINT NOT NULL PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    sur_name VARCHAR(30) NOT NULL
);

CREATE TABLE test_strategy_three.employee(
    id BIGINT NOT NULL PRIMARY KEY,
    company VARCHAR(30)
    FOREIGN KEY (id) REFERENCES test_strategy_three.person(person_id)
);

CREATE TABLE test_strategy_three.student(
    id BIGINT NOT NULL PRIMARY KEY,
    faculty VARCHAR(30),
    FOREIGN KEY (id) REFERENCES test_strategy_three.person(person_id)
);
