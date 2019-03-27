package pl.sda.intermediate16.playlists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static pl.sda.intermediate16.playlists.PlayMode.*;

public class PlayList extends Playable {
    private List<Playable> playables = new ArrayList<>();
    private PlayMode playMode;

    public PlayList(PlayMode playMode){
        this.playMode = playMode;
    }

    protected void addToPlayList(Playable playable){
        playables.add(playable);
    }


    @Override
    protected String play() {
        if (playMode == SEQUENTIAL) {
            return collectTitles(playables);
        } else if (playMode == LOOP) {
            String result = "";
            for (int i = 0; i < 10; i++) {
                result = result + collectTitles(playables);
            }
            // IntStream.range(1,11).forEach(); // zastepuje petle for each - wykona sie 10 razy wg tego schematu (dokonczyc)
            return result;
        } else if (playMode == RANDOM) { // wystrczy usunac if aby nie trzeba bylo wstawiac return na koncu
            List<Playable> tempList = new ArrayList<>(playables); // tworzymy liste przekazujaca inna liste, po to aby shuffle zmienial kolejnosc tylko w tej liscie
            Collections.shuffle(tempList);
            return collectTitles(tempList);
        }
        return "ERROR";
    }

    private String collectTitles(List<Playable>playables) {
        return playables.stream()
                .map(Playable::play) // zamiana listy na Stringi
                .collect(Collectors.joining("\n"));
    }
}
