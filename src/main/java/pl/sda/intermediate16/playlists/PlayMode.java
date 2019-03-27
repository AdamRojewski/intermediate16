package pl.sda.intermediate16.playlists;

public enum PlayMode {
    SEQUENTIAL("normalnie"), LOOP("petla"), RANDOM("losowo");

    private String plName;

    PlayMode(String plName) {
        this.plName=plName;
    }
}
