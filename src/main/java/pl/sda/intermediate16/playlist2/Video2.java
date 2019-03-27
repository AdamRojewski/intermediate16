package pl.sda.intermediate16.playlist2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Video2 extends Playable2 {
    private String title;

    @Override
    protected String playMe() {
        return "film "+ title;
    }
}
