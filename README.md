springDataExample
=================

A Basic Spring Data Example

About
=====

This example code illustrates how to use Spring Data to make data access simpler.

How to:
 * use multiple data stores
 * use the Bean container outside the web context
 * create an self contained jar with all dependencies included
 * how to use NamedQueries and Criteria Queries along side Spring Data
 * Identify the interactions between all these technologies

Requirements
============

 * Only the JDK and Maven is required to run this project.
 * MySQL is required for connection to a MySQL data store.  Otherwise an in memory H2 database is used.
 * If multiple data stores are used, MySQL is required for the second data store along with H2.
 * Mongo DB is required for Mongo connections

Configuration
=============

 * mvn clean install
 * java -jar target/springDataExample-1.0-SNAPSHOT.jar
 * The output explains what should be expected along with the actual output.  Comments in code also describe what is happening.