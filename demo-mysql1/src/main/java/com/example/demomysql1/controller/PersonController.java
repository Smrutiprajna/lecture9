package com.example.demomysql1.controller;

import com.example.demomysql1.model.CreatePersonRequest;
import com.example.demomysql1.model.Person;
import com.example.demomysql1.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Random;

@RestController
public class PersonController {
    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonService personService;
  /* @PostMapping("/person")
    public ResponseEntity createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest)
    {
    logger.info("CreatePersonRequest {}",createPersonRequest);
    Integer a=new Random().nextInt()%2;
   if(a==0)
    {
        logger.info("Random no.%2=0");
        throw new IndexOutOfBoundsException();
    }
    if(createPersonRequest.getFirstname()==null||createPersonRequest.getFirstname().isEmpty())
    {
        logger.info("Firstname cant be empty");
    }
        if(createPersonRequest.getLastname()==null||createPersonRequest.getLastname().isEmpty())
        {
            logger.info("Lastname cant be empty");
        }
        if(createPersonRequest.getDob()==null||createPersonRequest.getDob().isEmpty())
        {
            logger.info("Dob cant be empty");
        }
        logger.info("Saving info in DB");
        MultiValueMap<String,String> headers=new HttpHeaders();
        headers.add("Sample-response-header","Person-Response-Type");
       return new ResponseEntity<>(new Person(),headers, HttpStatus.CREATED);
    }*/

    @PostMapping("/person")
    public void createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest) {
        logger.info("CreatePersonRequest {}", createPersonRequest);
        logger.info("Saving info in DB");
        personService.createPerson(createPersonRequest);
    }

}
