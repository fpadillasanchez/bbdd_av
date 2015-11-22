CREATE TABLE dim_fisica
(
  "id_PersonaFisica" integer NOT NULL,
  descripcio text,
  CONSTRAINT "id_personaFisica" PRIMARY KEY ("id_PersonaFisica")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE dim_fisica
  OWNER TO oriol;

