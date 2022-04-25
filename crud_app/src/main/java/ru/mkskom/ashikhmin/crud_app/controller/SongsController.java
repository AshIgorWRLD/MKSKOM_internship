package ru.mkskom.ashikhmin.crud_app.controller;

import liquibase.pro.packaged.L;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.mkskom.ashikhmin.crud_app.dataobjects.SongData;
import ru.mkskom.ashikhmin.crud_app.domain.Person;
import ru.mkskom.ashikhmin.crud_app.exceptions.ResourceNotFoundException;
import ru.mkskom.ashikhmin.crud_app.repo.PersonRepo;
import ru.mkskom.ashikhmin.crud_app.transfermodels.Song;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("music")
public class SongsController {

    private final PersonRepo personRepo;

    @Autowired
    public SongsController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping("/{id}")
    public List<SongData> getSongs(@PathVariable("id") Long id){

        RestTemplate restTemplate = new RestTemplate();

        Person person = personRepo.findById(id).get();
        log.info("user was found: " + person.getName());
        Song song1 = new Song();
        song1.setUserLogin(person.getLogin());

        HttpEntity<Object> objectHttpEntity = new HttpEntity<>(song1);

        Song[] transferSong = restTemplate.postForObject(
                "http://localhost:8081/users/songs/search", objectHttpEntity, Song[].class);

        assert transferSong != null;

        return Arrays.stream(transferSong).map(song ->
                new SongData(person.getName(), song)).collect(Collectors.toList());
    }
}
