package ru.mkskom.ashikhmin.crud_app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mkskom.ashikhmin.crud_app.dao.PersonDAO;
import ru.mkskom.ashikhmin.crud_app.exceptions.NotFoundException;
import ru.mkskom.ashikhmin.crud_app.model.Person;
import ru.mkskom.ashikhmin.crud_app.service.impl.PersonServiceImpl;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("people")
public class PersonController {

    private PersonDAO people = new PersonDAO();
    private final PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> list(){
        return people.getPeople();
    }

    @GetMapping("{id}")
    public Person getOne(@PathVariable("id") int id){
        return people.getPeople().stream()
                .filter(x->x.getId() == id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        log.info("request for creating person with parameters {}", person);

        personService.create(person);

        people.add(person);

        return person;
    }

    @PutMapping("{id}")
    public Person update(@RequestBody Person person){
        Person updatingPerson = people.getPersonById(person.getId());

        updatingPerson.setName(person.getName());
        updatingPerson.setAge(person.getAge());
        updatingPerson.setEmail(person.getEmail());
        return updatingPerson;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Person person = getOne(id);

        people.delete(id);
    }
}
