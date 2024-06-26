PGDMP         #            	    {           Infozoos_DEG    11.21    11.21                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    16393    Infozoos_DEG    DATABASE     �   CREATE DATABASE "Infozoos_DEG" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE "Infozoos_DEG";
             postgres    false            �            1259    16518    animal    TABLE     �   CREATE TABLE public.animal (
    animalid integer NOT NULL,
    zooid integer NOT NULL,
    especieid integer NOT NULL,
    anonacimiento date NOT NULL,
    paisnacimiento character varying(200) NOT NULL
);
    DROP TABLE public.animal;
       public         postgres    false            �            1259    16516    animal_animalid_seq    SEQUENCE     �   CREATE SEQUENCE public.animal_animalid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.animal_animalid_seq;
       public       postgres    false    201                       0    0    animal_animalid_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.animal_animalid_seq OWNED BY public.animal.animalid;
            public       postgres    false    200            �            1259    16507    especie    TABLE       CREATE TABLE public.especie (
    especieid integer NOT NULL,
    nombrecomun character varying(100) NOT NULL,
    nombrecientifico character varying(200) NOT NULL,
    familiaanimal character varying(200) NOT NULL,
    peligroextincion boolean NOT NULL
);
    DROP TABLE public.especie;
       public         postgres    false            �            1259    16505    especie_especieid_seq    SEQUENCE     �   CREATE SEQUENCE public.especie_especieid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.especie_especieid_seq;
       public       postgres    false    199                       0    0    especie_especieid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.especie_especieid_seq OWNED BY public.especie.especieid;
            public       postgres    false    198            �            1259    16499    zoo    TABLE     �   CREATE TABLE public.zoo (
    zooid integer NOT NULL,
    nombre character varying(100) NOT NULL,
    ciudad character varying(100) NOT NULL,
    tamano double precision NOT NULL,
    presupuestoanual double precision NOT NULL
);
    DROP TABLE public.zoo;
       public         postgres    false            �            1259    16497    zoo_zooid_seq    SEQUENCE     �   CREATE SEQUENCE public.zoo_zooid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.zoo_zooid_seq;
       public       postgres    false    197                       0    0    zoo_zooid_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.zoo_zooid_seq OWNED BY public.zoo.zooid;
            public       postgres    false    196            �
           2604    16521    animal animalid    DEFAULT     r   ALTER TABLE ONLY public.animal ALTER COLUMN animalid SET DEFAULT nextval('public.animal_animalid_seq'::regclass);
 >   ALTER TABLE public.animal ALTER COLUMN animalid DROP DEFAULT;
       public       postgres    false    200    201    201            �
           2604    16510    especie especieid    DEFAULT     v   ALTER TABLE ONLY public.especie ALTER COLUMN especieid SET DEFAULT nextval('public.especie_especieid_seq'::regclass);
 @   ALTER TABLE public.especie ALTER COLUMN especieid DROP DEFAULT;
       public       postgres    false    198    199    199            �
           2604    16502 	   zoo zooid    DEFAULT     f   ALTER TABLE ONLY public.zoo ALTER COLUMN zooid SET DEFAULT nextval('public.zoo_zooid_seq'::regclass);
 8   ALTER TABLE public.zoo ALTER COLUMN zooid DROP DEFAULT;
       public       postgres    false    196    197    197                      0    16518    animal 
   TABLE DATA               [   COPY public.animal (animalid, zooid, especieid, anonacimiento, paisnacimiento) FROM stdin;
    public       postgres    false    201   I                 0    16507    especie 
   TABLE DATA               l   COPY public.especie (especieid, nombrecomun, nombrecientifico, familiaanimal, peligroextincion) FROM stdin;
    public       postgres    false    199   �                 0    16499    zoo 
   TABLE DATA               N   COPY public.zoo (zooid, nombre, ciudad, tamano, presupuestoanual) FROM stdin;
    public       postgres    false    197                     0    0    animal_animalid_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.animal_animalid_seq', 10, true);
            public       postgres    false    200                       0    0    especie_especieid_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.especie_especieid_seq', 10, true);
            public       postgres    false    198                       0    0    zoo_zooid_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.zoo_zooid_seq', 10, true);
            public       postgres    false    196            �
           2606    16523    animal animal_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY (animalid);
 <   ALTER TABLE ONLY public.animal DROP CONSTRAINT animal_pkey;
       public         postgres    false    201            �
           2606    16515    especie especie_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.especie
    ADD CONSTRAINT especie_pkey PRIMARY KEY (especieid);
 >   ALTER TABLE ONLY public.especie DROP CONSTRAINT especie_pkey;
       public         postgres    false    199            �
           2606    16504    zoo zoo_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY public.zoo
    ADD CONSTRAINT zoo_pkey PRIMARY KEY (zooid);
 6   ALTER TABLE ONLY public.zoo DROP CONSTRAINT zoo_pkey;
       public         postgres    false    197            �
           2606    16524    animal fk_animal_especie    FK CONSTRAINT     �   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT fk_animal_especie FOREIGN KEY (especieid) REFERENCES public.especie(especieid);
 B   ALTER TABLE ONLY public.animal DROP CONSTRAINT fk_animal_especie;
       public       postgres    false    201    2704    199            �
           2606    16529    animal fk_animal_zoo    FK CONSTRAINT     r   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT fk_animal_zoo FOREIGN KEY (zooid) REFERENCES public.zoo(zooid);
 >   ALTER TABLE ONLY public.animal DROP CONSTRAINT fk_animal_zoo;
       public       postgres    false    197    2702    201               �   x�e�=
1�z�^@����������fа�D¦��&�������+�����Q�<����O����Y\C���Tp�2�B�[�W��+�I�[#��y�z�a��L�����[��	V0��z�`�&�~w�w��"��7�           x�u�KN1�מS���f��BBb6�ؘ��5��U�T*���S�bx�ذI�����JI����:�90&��hE��.`�Y����aO��ps��n����
��'�n�q�=��'Q'��,�ǬW�<�b�A��^C��EXr(IvҢ�)`�@ž�&K��f]��hKݕ������[x�$���$����ї�\w�.�ǃu������)ѵ\m�{�?ےX�{�̹���_�-?K�Zb�Eʤ.��h�����ogUU�Uߓp         �   x�M�MJ1F�_N�H��u��A�A75m2�f:
^�#x1���E���We0і�bc��v|�84塓Ҩ/����
���j7�=���k$�g�︷_��sST'��q�$�N��n������j�-G.��d1'W𤧘�a�l��Bodś�ӵ�7EZ� #���;�L�ǘ����\u^C�x�+�5��(�E����,�͢�P�7�456�����.�3��_ϔRVnh�     