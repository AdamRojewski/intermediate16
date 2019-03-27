package pl.sda.intermediate16.playlists;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Music extends Playable{
    private String author;
    private String title;

    @Override
    protected String play() {
        return "Music: " + author +", " + title;
    }
}
