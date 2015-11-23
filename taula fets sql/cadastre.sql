--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5beta2
-- Dumped by pg_dump version 9.5beta2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: dim_Subtipusimoble; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "dim_Subtipusimoble" (
    "id_TipusInmoble" integer NOT NULL,
    "descTipusInmoble" text,
    "id_SubInmoble" integer,
    "descSubInmoble" text
);


ALTER TABLE "dim_Subtipusimoble" OWNER TO postgres;

--
-- Name: dim_fisica; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE dim_fisica (
    "id_PersonaFisica" integer NOT NULL,
    descripcio text
);


ALTER TABLE dim_fisica OWNER TO postgres;

--
-- Name: dim_juridica; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE dim_juridica (
    "id_personaJuridica" integer NOT NULL,
    descripcio text
);


ALTER TABLE dim_juridica OWNER TO postgres;

--
-- Name: dimencio_Sol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "dimencio_Sol" (
    "id_Sol" integer NOT NULL,
    "descSol" text,
    "id_TipusSol" integer,
    "descTipusSol" text
);


ALTER TABLE "dimencio_Sol" OWNER TO postgres;

--
-- Name: inmobleEstrella; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "inmobleEstrella" (
    "id_Sol" integer,
    "id_PersonaFisica" integer,
    "id_Personajuridica" integer,
    "id_TipusInmoble" integer,
    "id_SubInmoble" integer,
    "superficieTotal" integer,
    "id_InmobleEstrella" integer NOT NULL
);


ALTER TABLE "inmobleEstrella" OWNER TO postgres;

--
-- Data for Name: dim_Subtipusimoble; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "dim_Subtipusimoble" ("id_TipusInmoble", "descTipusInmoble", "id_SubInmoble", "descSubInmoble") FROM stdin;
2	inmoble feo	22	mansion
3	inmoble en construccion	33	torre
1	inmoble guay	4	chalet
\.


--
-- Data for Name: dim_fisica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dim_fisica ("id_PersonaFisica", descripcio) FROM stdin;
1	dueño rico
2	dueño pobre
3	dueño multimillonario
4	dueño rico rico
\.


--
-- Data for Name: dim_juridica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dim_juridica ("id_personaJuridica", descripcio) FROM stdin;
1	empresa s.l.
2	empresa s.a.
3	empresa multinacional
\.


--
-- Data for Name: dimencio_Sol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "dimencio_Sol" ("id_Sol", "descSol", "id_TipusSol", "descTipusSol") FROM stdin;
1	un suelo plano	11	suelo para mercadooonaa
2	suelo para cines	22	suelo cinesa diagonal
\.


--
-- Data for Name: inmobleEstrella; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "inmobleEstrella" ("id_Sol", "id_PersonaFisica", "id_Personajuridica", "id_TipusInmoble", "id_SubInmoble", "superficieTotal", "id_InmobleEstrella") FROM stdin;
1	1	1	1	\N	25	1
\.


--
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "inmobleEstrella"
    ADD CONSTRAINT id PRIMARY KEY ("id_InmobleEstrella");


--
-- Name: id_Sol; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "dimencio_Sol"
    ADD CONSTRAINT "id_Sol" PRIMARY KEY ("id_Sol");


--
-- Name: id_TipusInmoble; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "dim_Subtipusimoble"
    ADD CONSTRAINT "id_TipusInmoble" PRIMARY KEY ("id_TipusInmoble");


--
-- Name: id_personaFisica; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dim_fisica
    ADD CONSTRAINT "id_personaFisica" PRIMARY KEY ("id_PersonaFisica");


--
-- Name: id_personaJuridica; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dim_juridica
    ADD CONSTRAINT "id_personaJuridica" PRIMARY KEY ("id_personaJuridica");


--
-- Name: id_PersonaFisica; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "inmobleEstrella"
    ADD CONSTRAINT "id_PersonaFisica" FOREIGN KEY ("id_PersonaFisica") REFERENCES dim_fisica("id_PersonaFisica");


--
-- Name: id_Personajuridica; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "inmobleEstrella"
    ADD CONSTRAINT "id_Personajuridica" FOREIGN KEY ("id_Personajuridica") REFERENCES dim_juridica("id_personaJuridica");


--
-- Name: id_Sol; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "inmobleEstrella"
    ADD CONSTRAINT "id_Sol" FOREIGN KEY ("id_Sol") REFERENCES "dimencio_Sol"("id_Sol");


--
-- Name: id_Subtipusinmoble; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "inmobleEstrella"
    ADD CONSTRAINT "id_Subtipusinmoble" FOREIGN KEY ("id_SubInmoble") REFERENCES "dim_Subtipusimoble"("id_TipusInmoble");


--
-- Name: id_TipusInmoble; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "inmobleEstrella"
    ADD CONSTRAINT "id_TipusInmoble" FOREIGN KEY ("id_TipusInmoble") REFERENCES "dim_Subtipusimoble"("id_TipusInmoble");


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

