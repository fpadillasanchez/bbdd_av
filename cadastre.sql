--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

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
-- Name: cadastre; Type: TABLE; Schema: public; Owner: oriol; Tablespace: 
--

CREATE TABLE cadastre (
    "id_Cadastre" integer NOT NULL,
    "any" date,
    ciutat text
);


ALTER TABLE public.cadastre OWNER TO oriol;

--
-- Name: fisica; Type: TABLE; Schema: public; Owner: oriol; Tablespace: 
--

CREATE TABLE fisica (
    nom text,
    dni text
);


ALTER TABLE public.fisica OWNER TO oriol;

--
-- Name: geolocalizacion; Type: TABLE; Schema: public; Owner: oriol; Tablespace: 
--

CREATE TABLE geolocalizacion (
    id_geolocalitzacio integer NOT NULL,
    x integer,
    y integer,
    z integer
);


ALTER TABLE public.geolocalizacion OWNER TO oriol;

--
-- Name: inmoble; Type: TABLE; Schema: public; Owner: oriol; Tablespace: 
--

CREATE TABLE inmoble (
    "id_Inmoble" integer,
    data_baixa date,
    data_alta date,
    estat text,
    internet text,
    referencia_cadastral text,
    num_residents text,
    planta integer,
    "id_Cadastre" integer
);


ALTER TABLE public.inmoble OWNER TO oriol;

--
-- Name: juridica; Type: TABLE; Schema: public; Owner: oriol; Tablespace: 
--

CREATE TABLE juridica (
    nom text,
    "NIF" text,
    "primer_Cognom" text,
    "segon_Cognom" text
);


ALTER TABLE public.juridica OWNER TO oriol;

--
-- Name: persona; Type: TABLE; Schema: public; Owner: oriol; Tablespace: 
--

CREATE TABLE persona (
    nom text NOT NULL,
    telefon text,
    direccio text
);


ALTER TABLE public.persona OWNER TO oriol;

--
-- Name: sol; Type: TABLE; Schema: public; Owner: oriol; Tablespace: 
--

CREATE TABLE sol (
    id_sol integer NOT NULL,
    superficie integer,
    "id_Cadastre" integer
);


ALTER TABLE public.sol OWNER TO oriol;

--
-- Name: subtipus_inmoble; Type: TABLE; Schema: public; Owner: oriol; Tablespace: 
--

CREATE TABLE subtipus_inmoble (
    id_subtipus integer NOT NULL,
    descripcio character varying(30),
    nom text NOT NULL
);


ALTER TABLE public.subtipus_inmoble OWNER TO oriol;

--
-- Name: tipus_inmoble; Type: TABLE; Schema: public; Owner: oriol; Tablespace: 
--

CREATE TABLE tipus_inmoble (
    id_subtipus integer NOT NULL,
    nom text NOT NULL,
    descripcio character varying(30)
);


ALTER TABLE public.tipus_inmoble OWNER TO oriol;

--
-- Name: tipus_sol; Type: TABLE; Schema: public; Owner: oriol; Tablespace: 
--

CREATE TABLE tipus_sol (
    id_tipusol integer NOT NULL,
    nom text NOT NULL,
    descripcio character varying(30)
);


ALTER TABLE public.tipus_sol OWNER TO oriol;

--
-- Name: us; Type: TABLE; Schema: public; Owner: oriol; Tablespace: 
--

CREATE TABLE us (
    id_us integer NOT NULL,
    nom text NOT NULL,
    descripcio character varying(30)
);


ALTER TABLE public.us OWNER TO oriol;

--
-- Data for Name: cadastre; Type: TABLE DATA; Schema: public; Owner: oriol
--

COPY cadastre ("id_Cadastre", "any", ciutat) FROM stdin;
\.


--
-- Data for Name: fisica; Type: TABLE DATA; Schema: public; Owner: oriol
--

COPY fisica (nom, dni) FROM stdin;
\.


--
-- Data for Name: geolocalizacion; Type: TABLE DATA; Schema: public; Owner: oriol
--

COPY geolocalizacion (id_geolocalitzacio, x, y, z) FROM stdin;
\.


--
-- Data for Name: inmoble; Type: TABLE DATA; Schema: public; Owner: oriol
--

COPY inmoble ("id_Inmoble", data_baixa, data_alta, estat, internet, referencia_cadastral, num_residents, planta, "id_Cadastre") FROM stdin;
\.


--
-- Data for Name: juridica; Type: TABLE DATA; Schema: public; Owner: oriol
--

COPY juridica (nom, "NIF", "primer_Cognom", "segon_Cognom") FROM stdin;
\.


--
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: oriol
--

COPY persona (nom, telefon, direccio) FROM stdin;
Oriol	619417550	C7Major 17
\.


--
-- Data for Name: sol; Type: TABLE DATA; Schema: public; Owner: oriol
--

COPY sol (id_sol, superficie, "id_Cadastre") FROM stdin;
\.


--
-- Data for Name: subtipus_inmoble; Type: TABLE DATA; Schema: public; Owner: oriol
--

COPY subtipus_inmoble (id_subtipus, descripcio, nom) FROM stdin;
\.


--
-- Data for Name: tipus_inmoble; Type: TABLE DATA; Schema: public; Owner: oriol
--

COPY tipus_inmoble (id_subtipus, nom, descripcio) FROM stdin;
\.


--
-- Data for Name: tipus_sol; Type: TABLE DATA; Schema: public; Owner: oriol
--

COPY tipus_sol (id_tipusol, nom, descripcio) FROM stdin;
\.


--
-- Data for Name: us; Type: TABLE DATA; Schema: public; Owner: oriol
--

COPY us (id_us, nom, descripcio) FROM stdin;
\.


--
-- Name: geolocalizacion_pkey; Type: CONSTRAINT; Schema: public; Owner: oriol; Tablespace: 
--

ALTER TABLE ONLY geolocalizacion
    ADD CONSTRAINT geolocalizacion_pkey PRIMARY KEY (id_geolocalitzacio);


--
-- Name: id_Cadastre; Type: CONSTRAINT; Schema: public; Owner: oriol; Tablespace: 
--

ALTER TABLE ONLY cadastre
    ADD CONSTRAINT "id_Cadastre" PRIMARY KEY ("id_Cadastre");


--
-- Name: nom; Type: CONSTRAINT; Schema: public; Owner: oriol; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT nom PRIMARY KEY (nom);


--
-- Name: sol_pkey; Type: CONSTRAINT; Schema: public; Owner: oriol; Tablespace: 
--

ALTER TABLE ONLY sol
    ADD CONSTRAINT sol_pkey PRIMARY KEY (id_sol);


--
-- Name: subtipus_inmoble_pkey; Type: CONSTRAINT; Schema: public; Owner: oriol; Tablespace: 
--

ALTER TABLE ONLY subtipus_inmoble
    ADD CONSTRAINT subtipus_inmoble_pkey PRIMARY KEY (id_subtipus);


--
-- Name: tipus_inmoble_pkey; Type: CONSTRAINT; Schema: public; Owner: oriol; Tablespace: 
--

ALTER TABLE ONLY tipus_inmoble
    ADD CONSTRAINT tipus_inmoble_pkey PRIMARY KEY (id_subtipus);


--
-- Name: tipus_sol_pkey; Type: CONSTRAINT; Schema: public; Owner: oriol; Tablespace: 
--

ALTER TABLE ONLY tipus_sol
    ADD CONSTRAINT tipus_sol_pkey PRIMARY KEY (id_tipusol);


--
-- Name: us_pkey; Type: CONSTRAINT; Schema: public; Owner: oriol; Tablespace: 
--

ALTER TABLE ONLY us
    ADD CONSTRAINT us_pkey PRIMARY KEY (id_us);


--
-- Name: id_Cadastre; Type: FK CONSTRAINT; Schema: public; Owner: oriol
--

ALTER TABLE ONLY inmoble
    ADD CONSTRAINT "id_Cadastre" FOREIGN KEY ("id_Cadastre") REFERENCES cadastre("id_Cadastre");


--
-- Name: id_Cadastre; Type: FK CONSTRAINT; Schema: public; Owner: oriol
--

ALTER TABLE ONLY sol
    ADD CONSTRAINT "id_Cadastre" FOREIGN KEY ("id_Cadastre") REFERENCES cadastre("id_Cadastre");


--
-- Name: nom; Type: FK CONSTRAINT; Schema: public; Owner: oriol
--

ALTER TABLE ONLY fisica
    ADD CONSTRAINT nom FOREIGN KEY (nom) REFERENCES persona(nom);


--
-- Name: nom; Type: FK CONSTRAINT; Schema: public; Owner: oriol
--

ALTER TABLE ONLY juridica
    ADD CONSTRAINT nom FOREIGN KEY (nom) REFERENCES persona(nom);


--
-- Name: tipus_inmoble_id_subtipus_fkey; Type: FK CONSTRAINT; Schema: public; Owner: oriol
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

