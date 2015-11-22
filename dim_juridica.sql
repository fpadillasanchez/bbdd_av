CREATE TABLE dim_juridica
(
  "id_personaJuridica" integer NOT NULL,
  descripcio text,
  CONSTRAINT "id_personaJuridica" PRIMARY KEY ("id_personaJuridica")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE dim_juridica
  OWNER TO oriol;

