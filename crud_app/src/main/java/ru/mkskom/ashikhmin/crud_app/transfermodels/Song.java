package ru.mkskom.ashikhmin.crud_app.transfermodels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Song {

    private Long id;
    private String name;
    private String author;
    private String timeLength;
    private String userLogin;
}
