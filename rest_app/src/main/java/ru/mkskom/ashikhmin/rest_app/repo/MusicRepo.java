package ru.mkskom.ashikhmin.rest_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mkskom.ashikhmin.rest_app.entity.Song;

import java.util.List;

public interface MusicRepo extends JpaRepository<Song, Long> {

    List<Song> findByUserLogin(String login);

    List<Song> findByAuthor(String author);
}
