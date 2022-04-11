package ru.mkskom.ashikhmin.crud_app.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ru.mkskom.ashikhmin.crud_app.model.Person;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonDAO {

    private static int idCounter = 0;

    private List<Person> people = new ArrayList<>();

    public PersonDAO(){
        people.add(new Person(++idCounter, "Kanye", 40, "west@gmail.com"));
        people.add(new Person(++idCounter, "Drake", 35, "drizzy@gmail.com"));
        people.add(new Person(++idCounter, "Post Malone", 35, "posty@gmail.com"));
        people.add(new Person(++idCounter, "Kid Cudi", 35, "cudi@gmail.com"));
    }

    public Person getPersonById(int id){
        return people.stream()
                .filter(x-> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void add(Person person){
        person.setId(++idCounter);
        people.add(person);
    }

    public void delete(int id){
        people.remove(id);
    }
}
