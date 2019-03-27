package pl.sda.intermediate16.playlist2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Music2 extends Playable2{
    private String band;
    private String title;

    @Override
    protected String playMe() {
        return "zespol " + band + "tytul " + title;
    }
}
