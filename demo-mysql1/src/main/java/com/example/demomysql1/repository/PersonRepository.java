package com.example.demomysql1.repository;

import com.example.demomysql1.controller.PersonController;
import com.example.demomysql1.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class PersonRepository {
    private  Connection connection;
    public PersonRepository(Connection connection) throws SQLException {
      // Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:8080/jbdl36_person","root","Smruti@123");
        this.connection=connection;
        createTable();
   }
   private static Logger logger = LoggerFactory.getLogger(PersonController.class);
   // @Autowired


    public void createPerson(Person person) {
        //Logic to create the perosn into db
        try {
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl36_person","root","Smruti@123");
            Statement statement= connection.createStatement();
           boolean result=statement.execute("insert into person(id,first_name,last_name,age,dob)VALUES(3,'ABC','DEF',20,'2020-09-09')");
           logger.info("PersonRepository result {}",result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void createTable()
    {
        Statement statement= null;
        try {
            statement = connection.createStatement();
            statement.execute("create table person(id int primary key," +
                    "first_name varchar(30),last_name varchar(30),age int,dob varchar(12))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
