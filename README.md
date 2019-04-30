# Wildlife-Tracker
An application that allows Rangers to track wildlife sightings in the area.
## Description
The Forest Service is considering a proposal from a timber company to clearcut a nearby forest of Douglas Fir.
Before this proposal may be approved, they must complete an environmental impact study. 
You have been asked to build an application that allows Rangers to track wildlife sightings in the area

**Technologies and frame works Used**
1. java 11
2. spark core 2.12
3. Gradle 4.10
4. Spark Template Velocity
5. Junit 5
6. Postgres database

## Setup
 To create the necessary databases, launch postgres, then psql, and run the following commands:
In psql
> ```
> CREATE DATABASE wildlife_tracker;
> \c wildlife_tracker;
> CREATE TABLE animals(id serial PRIMARY KEY, name varchar, endangared varchar, health varchar, age varchar);
> CREATE TABLE stylists(id serial PRIMARY KEY,ranger_name varchar, location varchar, animal_id int, timestamp timestap);
> CREATE DATABASE CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
> \c wildlife_tracker_test
> CREATE TABLE animals(id serial PRIMARY KEY, name varchar, endangared varchar, health varchar, age varchar);
> CREATE TABLE stylists(id serial PRIMARY KEY,ranger_name varchar, location varchar, animal_id int, timestamp timestap);
## Lisense
Copyright (c) 2019 MIT License
