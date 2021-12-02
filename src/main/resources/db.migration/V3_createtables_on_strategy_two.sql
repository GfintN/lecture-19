CREATE TABLE test_strategy_two.program_author_name(
   PROGRAM_TYPE VARCHAR(20),
   id BIGINT NOT NULL PRIMARY KEY,
   first_name VARCHAR(30) NOT NULL,
   sure_name VARCHAR(30) NOT NULL,
   os_program_name VARCHAR(30),
   web_program_name VARCHAR(30)
);

CREATE TABLE test_strategy_two.os_programs(
    os_program_name VARCHAR(30)
);

CREATE TABLE test_strategy_two.web_programs(
    web_program_name VARCHAR(30)
);