package pl.sda.intermediate16.playlist2;

import pl.sda.intermediate16.playlists.Music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static pl.sda.intermediate16.playlist2.ModePlay.*;

public class Playlis2 extends Playable2 {

    Music music = new Music("bon jovi", "It's my life");
    Music music2 = new Music("Metallica", "Nothing Else matter");
    Music music3 = new Music("Bradley Cooper", "Shallow");

    public static void main(String[] args) {

    }

    List<Playable2> playable2s = new ArrayList<>();
    private ModePlay modePlay;
    private String result;

    public Playlis2(ModePlay modePlay) {
        this.modePlay = modePlay;
    }


    protected void addingToPlaylist(Playable2 playable2) {
        playable2s.add(playable2);
    }


    @Override
    protected String playMe() {
        if (modePlay == SEQUENTIAL) {
            return playable2s.stream()
                    .map(Playable2::playMe)
                    .collect(Collectors.joining());
        } else if (modePlay == RANDOM) {
            List<Playable2> tempList = new ArrayList<>();
            Collections.shuffle(tempList);
            return tempList.stream()
                    .map(Playable2::playMe)
                    .collect(Collectors.joining());
        } else if (modePlay == AGAINANDAGAIN) {
            for (int i = 0; i < 10; i++) {
                result = result + playable2s.stream()
                        .map(Playable2::playMe)
                        .collect(Collectors.joining());
            }
        }
        return "Error";
    }

    protected void playMyList() {
        Playlis2 playlis2 = new Playlis2(SEQUENTIAL);
        playlis2.addingToPlaylist(music);
        playlis2.addingToPlaylist(music2);
        playlis2.addingToPlaylist(music3);
        System.out.println(playlis2.playMe());
    }

}
