package ru.mkskom.ashikhmin.rest_app.entity;

import lombok.Getter;
import lombok.Setter;
import ru.mkskom.ashikhmin.rest_app.objects.TimeLength;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "songs")
@Getter
@Setter
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 2, max = 30)
    private String name;

    @NotBlank
    @Size(min = 5, max = 25)
    private String author;

    private String timeLength;

}
