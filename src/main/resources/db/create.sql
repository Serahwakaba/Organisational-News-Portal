CREATE DATABASE organisational_api;
\c organisational_api;
CREATE TABLE IF NOT EXISTS departments(
 id serial PRIMARY KEY;
 name VARCHAR;
 description VARCHAR;
 numberofemployees VARCHAR;
 );