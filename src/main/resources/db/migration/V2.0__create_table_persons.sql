CREATE TABLE persons
(
    id            SERIAL CONSTRAINT pk_id_person  PRIMARY KEY,
    name          VARCHAR(50) NOT NULL,
    date_of_birth DATE        NOT NULL,
    cpf           VARCHAR(11),
    email         VARCHAR(50) NOT NULL
);