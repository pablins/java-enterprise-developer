--Creación DB (se realiza desde el asistente de PgAdmin)
CREATE DATABASE "crud-jsp-servlet"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
--Creación tabla Persona
CREATE TABLE public.persona
(
    id serial NOT NULL,
    nombres character varying(50) NOT NULL,
    apellidos character varying(50) NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.persona
    OWNER to postgres;
	
--Poblamos tabla
INSERT INTO persona (nombres, apellidos) VALUES ('Pablo', 'Rodriguez');
INSERT INTO persona (nombres, apellidos) VALUES ('Nelson', 'Ardila');
INSERT INTO persona (nombres, apellidos) VALUES ('Beatriz', 'Arias');