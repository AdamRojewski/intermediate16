package pl.sda.intermediate16.playlists;

import org.junit.jupiter.api.Test;

class PlayListTest {
    protected Music music1 = new Music("Metallica", "Sad but true");
    protected Music music2 = new Music("Kult", "6 lat pozniej");
    protected Music music3 = new Music("U2", "With or Without you");
    protected Music music4 = new Music("Perfect", "Autobiografia");
    protected Music music5 = new Music("David Bowie", "Lazarus");
    protected Movie movie1 = new Movie("Casablanca");
    protected Movie movie2 = new Movie("Rocky");
    protected Movie movie3 = new Movie("Terminator");

    @Test
    void shouldWorkProperlyWithRandomMode() {
        PlayList playList = new PlayList(PlayMode.RANDOM);
        playList.addToPlayList(music1);
        playList.addToPlayList(music2);
        playList.addToPlayList(music3);
        playList.addToPlayList(music4);
        playList.addToPlayList(music5);
        playList.addToPlayList(movie1);
        playList.addToPlayList(movie2);
        playList.addToPlayList(movie3);
        System.out.println(playList.play());
    }

    @Test
    void shouldWorkProperlyWithSubPlayList() {
        PlayList playList = new PlayList(PlayMode.RANDOM);
        playList.addToPlayList(music1);
        playList.addToPlayList(music2);
        playList.addToPlayList(music3);
        playList.addToPlayList(movie1);
        playList.addToPlayList(movie2);
        PlayList subPlayList = new PlayList(PlayMode.SEQUENTIAL);
        subPlayList.addToPlayList(music4);
        subPlayList.addToPlayList(movie3);
        subPlayList.addToPlayList(playList);
       // playList.addToPlayList(subPlayList); - jesli dodamy subplaylist do listy to dostaniemy stack overflow blad
        System.out.println(playList.play());
    }

}