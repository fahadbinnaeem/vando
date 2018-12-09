--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.8
-- Dumped by pg_dump version 9.6.8

-- Started on 2018-12-09 13:15:09 PKT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12427)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 3596 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 2 (class 3079 OID 198913)
-- Name: postgis; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS postgis WITH SCHEMA public;


--
-- TOC entry 3597 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION postgis; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION postgis IS 'PostGIS geometry, geography, and raster spatial types and functions';


--
-- TOC entry 203 (class 1259 OID 200440)
-- Name: app_config_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.app_config_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.app_config_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 204 (class 1259 OID 200442)
-- Name: app_config; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.app_config (
    id integer DEFAULT nextval('public.app_config_id_seq'::regclass) NOT NULL,
    key character varying(255),
    scope character varying(50),
    description character varying(255),
    value character varying(512)
);


ALTER TABLE public.app_config OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 200457)
-- Name: items_item_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.items_item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.items_item_id_seq OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 200459)
-- Name: items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.items (
    item_id integer DEFAULT nextval('public.items_item_id_seq'::regclass) NOT NULL,
    user_id integer,
    description text,
    item_name text,
    category text,
    subcategory text,
    manufacturing_date text,
    photo_url text,
    location public.geometry(Point,4326),
    address text,
    quantity text,
    contact text
);


ALTER TABLE public.items OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 200473)
-- Name: transactions_transaction_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transactions_transaction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.transactions_transaction_id_seq OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 200475)
-- Name: transactions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transactions (
    transaction_id integer DEFAULT nextval('public.transactions_transaction_id_seq'::regclass) NOT NULL,
    item_id integer,
    comments text,
    buyer_user text,
    seller_user text,
    transaction_date timestamp without time zone,
    use_bykea boolean
);


ALTER TABLE public.transactions OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 200402)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id integer NOT NULL,
    username text,
    email text,
    contact text,
    address text,
    phone_uuid text,
    password text
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 200408)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_user_id_seq OWNER TO postgres;

--
-- TOC entry 3598 (class 0 OID 0)
-- Dependencies: 202
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


--
-- TOC entry 3441 (class 2604 OID 200412)
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);


--
-- TOC entry 3584 (class 0 OID 200442)
-- Dependencies: 204
-- Data for Name: app_config; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.app_config (id, key, scope, description, value) FROM stdin;
2	UPDATE_USER	application	update user sql	UPDATE users SET username = ?, email = ?, password = ?, contact = ?, address = ?, phone_uuid = ? WHERE user_id = ?
3	DELETE_USER	application	delete user sql	delete from users where user_id = ?
4	FIND_USER_EMAIL	application	find user by email sql	SELECT user_id, username, email, contact, address, phone_uuid FROM users WHERE email = ?
5	FIND_ALL_USER	application	find all users sql	SELECT user_id, username, email, contact, address, phone_uuid FROM users
1	INSERT_USER	application	inser user sql	INSERT INTO users (username, email, password, contact, address, phone_uuid) VALUES (?, ?, ?, ?, ?, ?)
6	INSERT_ITEM	application	inset item sql	INSERT INTO items (user_id,description,item_name,category,subcategory,manufacturing_date,photo_url,location,address,quantity,contact) VALUES (?,?,?,?,?,?,?,ST_GEOMFROMTEXT(?, 4326),?,?,?)
\.


--
-- TOC entry 3599 (class 0 OID 0)
-- Dependencies: 203
-- Name: app_config_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.app_config_id_seq', 6, true);


--
-- TOC entry 3586 (class 0 OID 200459)
-- Dependencies: 206
-- Data for Name: items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.items (item_id, user_id, description, item_name, category, subcategory, manufacturing_date, photo_url, location, address, quantity, contact) FROM stdin;
2	2	?	?	?	?	?	?	0101000020E610000085EB51B81E5552400AD7A3703DAA4040	?	?	?
4	2	sasdfa	abc	asdafdadfa	\N	aaa	/tmp/abcfile	0101000020E610000033333333335352403333333333B34040	adaaaaa	\N	aodfadf
\.


--
-- TOC entry 3600 (class 0 OID 0)
-- Dependencies: 205
-- Name: items_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.items_item_id_seq', 4, true);


--
-- TOC entry 3439 (class 0 OID 199210)
-- Dependencies: 187
-- Data for Name: spatial_ref_sys; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.spatial_ref_sys (srid, auth_name, auth_srid, srtext, proj4text) FROM stdin;
\.


--
-- TOC entry 3588 (class 0 OID 200475)
-- Dependencies: 208
-- Data for Name: transactions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transactions (transaction_id, item_id, comments, buyer_user, seller_user, transaction_date, use_bykea) FROM stdin;
\.


--
-- TOC entry 3601 (class 0 OID 0)
-- Dependencies: 207
-- Name: transactions_transaction_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transactions_transaction_id_seq', 1, false);


--
-- TOC entry 3581 (class 0 OID 200402)
-- Dependencies: 201
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, username, email, contact, address, phone_uuid, password) FROM stdin;
2	testUpdated	test@abc.com	asd	1234659	asdfasdf	\N
\.


--
-- TOC entry 3602 (class 0 OID 0)
-- Dependencies: 202
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_user_id_seq', 2, true);


--
-- TOC entry 3448 (class 2606 OID 200450)
-- Name: app_config appconfig_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_config
    ADD CONSTRAINT appconfig_pk PRIMARY KEY (id);


--
-- TOC entry 3450 (class 2606 OID 200452)
-- Name: app_config appkey_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.app_config
    ADD CONSTRAINT appkey_unique UNIQUE (key);


--
-- TOC entry 3452 (class 2606 OID 200467)
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_pkey PRIMARY KEY (item_id);


--
-- TOC entry 3454 (class 2606 OID 200483)
-- Name: transactions transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (transaction_id);


--
-- TOC entry 3446 (class 2606 OID 200418)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 3455 (class 2606 OID 200468)
-- Name: items items_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- TOC entry 3456 (class 2606 OID 200484)
-- Name: transactions transactions_item_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_item_id_fkey FOREIGN KEY (item_id) REFERENCES public.items(item_id);


-- Completed on 2018-12-09 13:15:10 PKT

--
-- PostgreSQL database dump complete
--

