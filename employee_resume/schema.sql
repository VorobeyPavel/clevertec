CREATE TABLE public.employees
(
    id serial NOT NULL,
    name character varying NOT NULL,
    surname character varying NOT NULL,
    department character varying NOT NULL,
    salary character varying NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.employees
    OWNER to postgres;