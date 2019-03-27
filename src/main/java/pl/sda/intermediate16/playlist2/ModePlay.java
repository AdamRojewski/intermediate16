package pl.sda.intermediate16.playlist2;

public enum ModePlay {
    SEQUENTIAL("sekwencyjny"), RANDOM("zwykly"), AGAINANDAGAIN("zapetlony");
private String nazwa;

    ModePlay(String nazwa) {
        this.nazwa = nazwa;
    }
}
