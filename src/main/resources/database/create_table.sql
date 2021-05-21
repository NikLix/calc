-- Table: public.examples

-- DROP TABLE public.examples;

CREATE TABLE public.examples
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    left_operand text COLLATE pg_catalog."default",
    right_operand text COLLATE pg_catalog."default",
    operation text COLLATE pg_catalog."default",
    result text COLLATE pg_catalog."default",
    CONSTRAINT examples_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.examples
    OWNER to postgres;