-- Table: public._layer

-- DROP TABLE public._layer;

CREATE TABLE public._layer
(
    node_id text COLLATE pg_catalog."default" NOT NULL,
    node_type text COLLATE pg_catalog."default",
    parent_node_id text COLLATE pg_catalog."default",
    layer_id text COLLATE pg_catalog."default",
    layer_name text COLLATE pg_catalog."default",
    layer_type text COLLATE pg_catalog."default",
    layer_url text COLLATE pg_catalog."default",
    layer_opacity numeric,
    layer_order integer,
    CONSTRAINT _layer_node_pkey PRIMARY KEY (node_id)
)

TABLESPACE pg_default;

ALTER TABLE public._layer
    OWNER to postgres;