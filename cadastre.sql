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
-- Name: cadastre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cadastre (
    "id_Cadastre" integer NOT NULL,
    ciutat text,
    "any" integer
);


ALTER TABLE cadastre OWNER TO postgres;

--
-- Name: estInmoble; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "estInmoble" (
    "id_personaFisica" integer,
    "id_TipusInmoble" integer,
    "id_PersonaJuridica" integer,
    "id_SubInmoble" integer,
    "id_TipusSol" integer,
    "id_Sol" integer,
    "id_Any" integer,
    "id_Mes" integer,
    "id_Dia" integer,
    "superficieTotal" integer
);


ALTER TABLE "estInmoble" OWNER TO postgres;

--
-- Name: fisica; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE fisica (
    nom text,
    dni text,
    "idPersona" integer
);


ALTER TABLE fisica OWNER TO postgres;

--
-- Name: geolocalizacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE geolocalizacion (
    id_geolocalitzacio integer NOT NULL,
    x integer,
    y integer,
    z integer
);


ALTER TABLE geolocalizacion OWNER TO postgres;

--
-- Name: inmoble; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE inmoble (
    "id_Inmoble" integer NOT NULL,
    data_baixa date,
    data_alta date,
    estat text,
    internet text,
    referencia_cadastral text,
    num_residents text,
    planta integer,
    "id_Cadastre" integer
);


ALTER TABLE inmoble OWNER TO postgres;

--
-- Name: juridica; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE juridica (
    nom text,
    "NIF" text,
    "primer_Cognom" text,
    "segon_Cognom" text,
    "idPersona" integer
);


ALTER TABLE juridica OWNER TO postgres;

--
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE persona (
    telefon text,
    direccio text,
    "id_Persona" integer
);


ALTER TABLE persona OWNER TO postgres;

--
-- Name: sol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sol (
    id_sol integer NOT NULL,
    superficie integer,
    "id_Cadastre" integer
);


ALTER TABLE sol OWNER TO postgres;

--
-- Name: subtipus_inmoble; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE subtipus_inmoble (
    id_subtipus integer NOT NULL,
    descripcio character varying(30),
    nom text NOT NULL
);


ALTER TABLE subtipus_inmoble OWNER TO postgres;

--
-- Name: tipus_inmoble; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipus_inmoble (
    id_subtipus integer NOT NULL,
    nom text NOT NULL,
    descripcio character varying(30)
);


ALTER TABLE tipus_inmoble OWNER TO postgres;

--
-- Name: tipus_sol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipus_sol (
    id_tipusol integer NOT NULL,
    nom text NOT NULL,
    descripcio character varying(30),
    "id_Sol" integer
);


ALTER TABLE tipus_sol OWNER TO postgres;

--
-- Name: us; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE us (
    id_us integer NOT NULL,
    nom text NOT NULL,
    descripcio character varying(30)
);


ALTER TABLE us OWNER TO postgres;

--
-- Data for Name: cadastre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cadastre ("id_Cadastre", ciutat, "any") FROM stdin;
1	barcelona	2000
2	madrid	2002
\.


--
-- Data for Name: estInmoble; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "estInmoble" ("id_personaFisica", "id_TipusInmoble", "id_PersonaJuridica", "id_SubInmoble", "id_TipusSol", "id_Sol", "id_Any", "id_Mes", "id_Dia", "superficieTotal") FROM stdin;
\.


--
-- Data for Name: fisica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY fisica (nom, dni, "idPersona") FROM stdin;
Oriol	15247859A	1
Fernando	15247859B	3
Jaume	15247859A	4
carles	1564646867a	5
\.


--
-- Data for Name: geolocalizacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY geolocalizacion (id_geolocalitzacio, x, y, z) FROM stdin;
\.


--
-- Data for Name: inmoble; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY inmoble ("id_Inmoble", data_baixa, data_alta, estat, internet, referencia_cadastral, num_residents, planta, "id_Cadastre") FROM stdin;
3	1991-12-20	1992-12-20	perfecto	si	1565645fa4f5d6asf4	4	2	2
4	1991-12-20	1993-12-20	perfecto	no	15651234fa4f5d6asf4	4	2	2
\.


--
-- Data for Name: juridica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY juridica (nom, "NIF", "primer_Cognom", "segon_Cognom", "idPersona") FROM stdin;
empresa textil	45678964R	queso	manchego	1
\.


--
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY persona (telefon, direccio, "id_Persona") FROM stdin;
619417550	C7Major 17	\N
5555555	c/falsa 123	1
1111111	c/rosello	3
2222222	c/dos de maig	4
333332222	c/tres de maig	5
44442222	c/cinc de maig	6
\.


--
-- Data for Name: sol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sol (id_sol, superficie, "id_Cadastre") FROM stdin;
3	25	1
2	40	2
\.


--
-- Data for Name: subtipus_inmoble; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY subtipus_inmoble (id_subtipus, descripcio, nom) FROM stdin;
3	zona para empresas	los x
2	zona para particulares	los y
\.


--
-- Data for Name: tipus_inmoble; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipus_inmoble (id_subtipus, nom, descripcio) FROM stdin;
3	piso de proteccion oficial	piso landa
\.


--
-- Data for Name: tipus_sol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipus_sol (id_tipusol, nom, descripcio, "id_Sol") FROM stdin;
1	sol per a concerts	sol pavimentat	2
\.


--
-- Data for Name: us; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY us (id_us, nom, descripcio) FROM stdin;
\.


--
-- Name: geolocalizacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY geolocalizacion
    ADD CONSTRAINT geolocalizacion_pkey PRIMARY KEY (id_geolocalitzacio);


--
-- Name: id_Cadastre; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cadastre
    ADD CONSTRAINT "id_Cadastre" PRIMARY KEY ("id_Cadastre");


--
-- Name: id_Inmoble; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY inmoble
    ADD CONSTRAINT "id_Inmoble" PRIMARY KEY ("id_Inmoble");


--
-- Name: id_Persona; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT "id_Persona" UNIQUE ("id_Persona");


--
-- Name: sol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sol
    ADD CONSTRAINT sol_pkey PRIMARY KEY (id_sol);


--
-- Name: subtipus_inmoble_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY subtipus_inmoble
    ADD CONSTRAINT subtipus_inmoble_pkey PRIMARY KEY (id_subtipus);


--
-- Name: tipus_inmoble_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipus_inmoble
    ADD CONSTRAINT tipus_inmoble_pkey PRIMARY KEY (id_subtipus);


--
-- Name: tipus_sol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipus_sol
    ADD CONSTRAINT tipus_sol_pkey PRIMARY KEY (id_tipusol);


--
-- Name: us_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY us
    ADD CONSTRAINT us_pkey PRIMARY KEY (id_us);


--
-- Name: idPersona; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fisica
    ADD CONSTRAINT "idPersona" FOREIGN KEY ("idPersona") REFERENCES persona("id_Persona");


--
-- Name: idPersona; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY juridica
    ADD CONSTRAINT "idPersona" FOREIGN KEY ("idPersona") REFERENCES persona("id_Persona");


--
-- Name: id_Cadastre; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sol
    ADD CONSTRAINT "id_Cadastre" FOREIGN KEY ("id_Cadastre") REFERENCES cadastre("id_Cadastre");


--
-- Name: id_PersonFisica; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "estInmoble"
    ADD CONSTRAINT "id_PersonFisica" FOREIGN KEY ("id_personaFisica") REFERENCES persona("id_Persona");


--
-- Name: id_PersonaJuridica; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "estInmoble"
    ADD CONSTRAINT "id_PersonaJuridica" FOREIGN KEY ("id_PersonaJuridica") REFERENCES persona("id_Persona");


--
-- Name: id_Sol; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "estInmoble"
    ADD CONSTRAINT "id_Sol" FOREIGN KEY ("id_Sol") REFERENCES sol(id_sol);


--
-- Name: id_Sol; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipus_sol
    ADD CONSTRAINT "id_Sol" FOREIGN KEY ("id_Sol") REFERENCES sol(id_sol);


--
-- Name: id_SubInmoble; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "estInmoble"
    ADD CONSTRAINT "id_SubInmoble" FOREIGN KEY ("id_SubInmoble") REFERENCES subtipus_inmoble(id_subtipus);


--
-- Name: id_TipusSol; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "estInmoble"
    ADD CONSTRAINT "id_TipusSol" FOREIGN KEY ("id_TipusSol") REFERENCES tipus_sol(id_tipusol);


--
-- Name: tipus_inmoble_id_subtipus_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipus_inmoble
    ADD CONSTRAINT tipus_inmoble_id_subtipus_fkey FOREIGN KEY (id_subtipus) REFERENCES subtipus_inmoble(id_subtipus);


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

