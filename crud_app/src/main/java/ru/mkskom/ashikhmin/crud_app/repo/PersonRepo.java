package ru.mkskom.ashikhmin.crud_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mkskom.ashikhmin.crud_app.domain.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
