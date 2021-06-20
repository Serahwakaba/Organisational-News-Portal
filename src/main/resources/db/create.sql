CREATE DATABASE organisational_api;
\c organisational_api;

CREATE TABLE IF NOT EXISTS departments(
 id serial PRIMARY KEY;
 name VARCHAR;
 description VARCHAR;
 numberofemployees VARCHAR;
 );

 CREATE TABLE IF NOT EXISTS news (
  id serial PRIMARY KEY ,
  content VARCHAR,
  description VARCHAR,
  departmentid int
 );