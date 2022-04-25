package ru.mkskom.ashikhmin.crud_app.dataobjects;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mkskom.ashikhmin.crud_app.transfermodels.Song;

@Data
@NoArgsConstructor
public class SongData {

    private String userName;
    private String songName;
    private String songAuthor;
    private String songLength;

    public SongData(String userName, Song transferSong){
        this.userName = userName;
        this.songName = transferSong.getName();
        this.songAuthor = transferSong.getAuthor();
        this.songLength = transferSong.getTimeLength();
    }
}
