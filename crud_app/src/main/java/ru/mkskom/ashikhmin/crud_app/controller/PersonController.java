package ru.mkskom.ashikhmin.crud_app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mkskom.ashikhmin.crud_app.domain.Person;
import ru.mkskom.ashikhmin.crud_app.exceptions.ResourceNotFoundException;
import ru.mkskom.ashikhmin.crud_app.repo.PersonRepo;

import javax.validation.Valid;
import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Validated
@RestController
@RequestMapping("people")
@Api(description = "Контроллер пользователей")
public class PersonController {

    private final PersonRepo personRepo;

    @Autowired
    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping
    @ApiOperation("Получение списка пользователей")
    public ResponseEntity<List<Person>> list(){
        List<Person> people = personRepo.findAll();
        if(people.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("{id}")
    @ApiOperation("Получение пользователя по id")
    public ResponseEntity<Person> getOne(@PathVariable("id") long id) {
        Person person = personRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found person with id = " + id));

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping(consumes = {"*/*"})
    @ApiOperation("Создание нового пользователя")
    public ResponseEntity<Person> create(@Valid @RequestBody Person person){
        log.info("request for creating person with parameters {}", person);

        return new ResponseEntity<>(personRepo.save(person), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @ApiOperation("Обновление информации о существующем пользователе")
    public ResponseEntity<Person> update(@PathVariable("id") long id,
                                         @Valid @RequestBody Person person){
        Person personFromDataBase = personRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found person with id = " + id));
        log.info("Person from data base: " + personFromDataBase);

        BeanUtils.copyProperties(person, personFromDataBase, getNullPropertiesString(person));
        return new ResponseEntity<>(personRepo.save(personFromDataBase), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Удаление пользователя")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Person person) {
        personRepo.delete(person);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @ApiOperation("Удаление всех пользователей")
    public ResponseEntity<HttpStatus> deleteAll(){
        personRepo.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private String[] getNullPropertiesString(Object source){
        BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] propertyDescriptors = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        emptyNames.add("id");
        for (PropertyDescriptor pd : propertyDescriptors){
            if(src.getPropertyValue(pd.getName()) == null){
                emptyNames.add(pd.getName());
            }
        }
        emptyNames.forEach(log::info);
        return emptyNames.toArray(new String[0]);
    }
}
