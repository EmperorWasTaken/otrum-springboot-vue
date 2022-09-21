package com.example.otrum.person;

import org.springframework.stereotype.Service;

import java.util.List;

@Service // To locate Spring Bean
public class PersonService {
    public List<Person> persons() {
        return List.of(
                new Person(
                        "John Doe",
                        44
                ),
                new Person(
                        "Jane Doe",
                        22
                )
        );
    }
    public void addNewPerson(Person person) {
        new Person(person.getName(), person.getAge());
    }

}
