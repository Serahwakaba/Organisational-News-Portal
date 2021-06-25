# Organisational-News-Portal
Create a rest REST API for querying and retrieving scoped news and information. There should be news/articles/posts that are available to all employees without navigating into any department, and others that are housed/classified within departments
#author
Serahwakaba

### Prerequisites

 * An up-to-date browser, preferably chrome or mozilla
 * Internet connection


### Technologies used

[Java ]
* [Intellij Idea]
* [Spark]
* [HTML]
* [Gradle]
* [Postgres SQL]

  ### END POINTS:


                |URL                                               |HTTP            |DESCRIPTIONS         
                          
               |/user                                              |get             |gets user details          
               |/user/departments                                  |get             |gets departments details
               |/users/departments                                 |post            |post  to department table       
               |/user//departments/new                             |post            |login new department details     
               |/departments/:id/news                              |get             |get news by id                       
               |/users/:id                                         |get             |get users Id                               
               |/users/new                                         |get             |get new users
               |/news                                              |post            |post new news
               |//news                                             |get             |get news

### Installation guide :notebook:

  If you want to use this as your template, here's how to go about it:

  * Install Git on you machine
  * Maneouver to 'clone or download' button and get the link
  * --Linux Users-- open your terminal and run the 'git clone ...' command in a directory of your choice
  * --for Windows Users-- Navigate to the location you'd want the repository located, right click and select "git bash here"
  * Clone the repository
  * Upon completion, navigate to the cloned repository
  Feel free to edit the files to your prefered taste

  * Now build the Database to enable storing of created instances
### CREATING TABLES:
In Postgres SQL:

    * CREATE DATABASE organisational_api;

    *CREATE TABLE IF NOT EXISTS departments(
 id serial PRIMARY KEY,
 name VARCHAR,
 description VARCHAR,
 numberofemployees VARCHAR
 );
 
 *CREATE TABLE  news (
  id serial PRIMARY KEY ,
  content VARCHAR,
  description VARCHAR,
  departmentid int
 );
 
 *CREATE TABLE IF NOT EXISTS userName (
  id serial PRIMARY KEY ,
  name VARCHAR,
  departmentid int,
  role VARCHAR
 );
 
*CREATE DATABASE organisational_api_test WITH TEMPLATE organisational_api;
  * CREATE DATABASE school_system_test;

    ### DROPPING TABLES
     
     *  nativage to main/resources/db 
     
     * run  psql < drop.sql



### support $ contact:

* Phone number's:
  [+245703661311]
* Email:
  
  saragathoni888@gmail.com
### LICENSE
 This website is under the MIT license which can be found [HERE](LICENSE).
 Copyright (c) 2021  wakaba
