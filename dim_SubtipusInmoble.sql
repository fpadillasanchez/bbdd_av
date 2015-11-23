CREATE TABLE "dim_Subtipusimoble"
(
  "id_TipusInmoble" integer NOT NULL,
  "descTipusInmoble" text,
  "id_SubInmoble" integer,
  "descSubInmoble" text,
  CONSTRAINT "id_TipusInmoble" PRIMARY KEY ("id_TipusInmoble")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "dim_Subtipusimoble"
  OWNER TO postgres;

