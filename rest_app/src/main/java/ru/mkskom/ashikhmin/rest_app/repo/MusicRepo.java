package ru.mkskom.ashikhmin.rest_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepo extends JpaRepository<Person, Long> {

}
