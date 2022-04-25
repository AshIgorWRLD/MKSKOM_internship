package ru.mkskom.ashikhmin.rest_app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mkskom.ashikhmin.rest_app.entity.Song;
import ru.mkskom.ashikhmin.rest_app.exceptions.ResourceNotFoundException;
import ru.mkskom.ashikhmin.rest_app.repo.MusicRepo;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("songs")
@Api(description = "Контроллер песен в плейлисте")
public class PlaylistController {

    private final MusicRepo musicRepo;

    @Autowired
    public PlaylistController(MusicRepo musicRepo) {
        this.musicRepo = musicRepo;
    }

    @GetMapping
    @ApiOperation("Получение списка музыки")
    public ResponseEntity<List<Song>> list(){
        List<Song> songs = musicRepo.findAll();
        if(songs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    @ApiOperation("Получение музыки по id")
    public ResponseEntity<Song> getOne(@PathVariable("id") long id) {
        Song song = musicRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found song with id = " + id));

        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @GetMapping("login/{login}")
    @ApiOperation("Получение музыки по логину")
    public ResponseEntity<List<Song>> getOneByLogin(@PathVariable("login") String login) {
        List<Song> songs = musicRepo.findByUserLogin(login);

        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping("search")
    @ApiOperation("Получение музыки по автору")
    public ResponseEntity<List<Song>> getOneByAuthor(@RequestBody Song song) {

        List<Song> songs = musicRepo.findAll(Example.of(song));
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping(consumes = {"*/*"})
    @ApiOperation("Создание нового объекта музыки привязанной к юзеру")
    public ResponseEntity<Song> create(@Valid @RequestBody Song song){
        log.info("request for creating song with parameters {}", song);

        return new ResponseEntity<>(musicRepo.save(song), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @ApiOperation("Обновление информации о существующей музыке")
    public ResponseEntity<Song> update(@PathVariable("id") long id,
                                         @Valid @RequestBody Song song){
        Song songFromDataBase = musicRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found song with id = " + id));
        log.info("Song from data base: " + songFromDataBase);

        BeanUtils.copyProperties(song, songFromDataBase, "id");
        return new ResponseEntity<>(musicRepo.save(songFromDataBase), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Удаление музыки")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Song song) {
        musicRepo.delete(song);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @ApiOperation("Удаление всей музыки")
    public ResponseEntity<HttpStatus> deleteAll(){
        musicRepo.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
