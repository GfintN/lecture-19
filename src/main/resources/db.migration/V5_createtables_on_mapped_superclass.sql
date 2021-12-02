CREATE TABLE test_mapped_superclass.fruits(
   fruit_name VARCHAR(100) NOT NULL,
   id BIGINT NOT NULL PRIMARY KEY,
   create_date DATE NOT NULL,
   shelf_life DATE NOT NULL
);

CREATE TABLE test_mapped_superclass.vegetables(
   vegetable_name VARCHAR(100) NOT NULL,
   id BIGINT PRIMARY KEY,
   create_date DATE NOT NULL,
   shelf_life DATE NOT NULL
);