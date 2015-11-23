CREATE TABLE "dimencio_Sol"
(
  "id_Sol" integer NOT NULL,
  "descSol" text,
  "id_TipusSol" integer,
  "descTipusSol" text,
  CONSTRAINT "id_Sol" PRIMARY KEY ("id_Sol")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "dimencio_Sol"
  OWNER TO oriol;

