package ru.mkskom.ashikhmin.rest_app.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import ru.mkskom.ashikhmin.rest_app.regexes.Regexes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "songs")
@Getter
@Setter
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 30)
    private String name;

    @NotBlank
    @Size(min = 5, max = 25)
    private String author;

    @NotBlank
    @Column(name = "length")
    @Pattern(regexp = Regexes.TIME)
    private String timeLength;

    @NotBlank
    @Size(min = 5, max = 25)
    @Pattern(regexp = Regexes.LETTERS_AND_NUMBERS)
    @Column(name = "login")
    private String userLogin;

    public Song(){}

    public Song(String name, String author, String timeLength, String userLogin){
        this.name = name;
        this.author = author;
        this.timeLength = timeLength;
        this.userLogin = userLogin;
    }

    public Song(String author){
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Song song = (Song) o;
        return id != null && Objects.equals(id, song.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
