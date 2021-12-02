CREATE TABLE test_strategy_one.animal_name(
   id BIGINT PRIMARY KEY,
   name VARCHAR(30)
);

CREATE TABLE test_strategy_one.cats(
   id BIGINT PRIMARY KEY,
   cat_breed VARCHAR(100) NOT NULL,
   name VARCHAR(30)
);

CREATE TABLE test_strategy_one.dogs(
     id BIGINT PRIMARY KEY,
     dog_breed VARCHAR(100) NOT NULL,
     name VARCHAR(30)
);
