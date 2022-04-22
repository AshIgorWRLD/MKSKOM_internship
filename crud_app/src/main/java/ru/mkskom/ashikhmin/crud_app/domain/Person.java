package ru.mkskom.ashikhmin.crud_app.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import ru.mkskom.ashikhmin.crud_app.regexes.Regexes;
import ru.mkskom.ashikhmin.crud_app.validators.interfaces.UserName;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "people")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 30)
    @UserName
    private String name;

    @NotBlank
    @Size(min = 5, max = 30)
    @Pattern(regexp = Regexes.LETTERS_AND_NUMBERS)
    private String login;

    @NotBlank
    @Size(min = 5, max = 25)
    @Pattern(regexp = Regexes.HAS_NUMBERS)
    private String password;

    public Person(){}

    public Person(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString(){
        return "Person{" + "id=" + this.id + ", name=" + this.name + ", login=" +
                this.login + ", password=" + this.password + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return id != null && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
