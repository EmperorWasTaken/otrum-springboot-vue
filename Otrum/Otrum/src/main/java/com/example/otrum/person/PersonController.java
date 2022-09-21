package com.example.otrum.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/v1/persons")
@CrossOrigin({"http://localhost:3000/", "http://localhost:3000/api/v1/persons"})
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> persons () {
        return personService.persons();
    }

    // Not working, 405 Method Not Allowed
    @PostMapping(value = "/api/v1/persons/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> addNewPerson(@RequestParam String name, @RequestParam int age) {
        personService.addNewPerson(new Person(name, age));
        return new ResponseEntity<>(new Person(name, age), HttpStatus.CREATED);
    }

}


