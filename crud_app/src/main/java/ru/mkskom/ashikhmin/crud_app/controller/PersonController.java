package ru.mkskom.ashikhmin.crud_app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mkskom.ashikhmin.crud_app.domain.Person;
import ru.mkskom.ashikhmin.crud_app.repo.PersonRepo;

import java.util.List;

@Slf4j
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
    public List<Person> list(){
        return personRepo.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Получение пользователя по id")
    public Person getOne(@PathVariable("id") Person person){
        return person;
    }

    @PostMapping
    @ApiOperation("Создание нового пользователя")
    public Person create(@RequestBody Person person){
        log.info("request for creating person with parameters {}", person);

        return personRepo.save(person);
    }

    @PutMapping("{id}")
    @ApiOperation("Обновление информации о существующем пользователе")
    public Person update(@PathVariable("id") Person personFromDataBase,
                         @RequestBody Person person){
        BeanUtils.copyProperties(person, personFromDataBase, "id");
        return personRepo.save(person);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Удаление пользователя")
    public void delete(@PathVariable("id") Person person){
        personRepo.delete(person);
    }
}
