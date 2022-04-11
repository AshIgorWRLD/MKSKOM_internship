package ru.mkskom.ashikhmin.spring.dao;

import org.springframework.stereotype.Component;
import ru.mkskom.ashikhmin.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int peopleCounter;
    private final List<Person> people;

    public PersonDAO(){
        people = new ArrayList<>();
        people.add(new Person( ++peopleCounter, "Kanye", 40, "kanye@gmail.com"));
        people.add(new Person( ++peopleCounter, "Drake", 35, "drizzy@gmail.com"));
        people.add(new Person( ++peopleCounter, "MARKUL", 29, "mark@gmail.com"));
        people.add(new Person( ++peopleCounter, "Juice", 21, "wrld@gmail.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++peopleCounter);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(person->person.getId() == id);
    }
}
