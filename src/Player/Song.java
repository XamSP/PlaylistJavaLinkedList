package Player;

public class Song {

    private String title;

    private String artist;

    private double duration;

    public Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public Song(String title, double duration) {
        this(title, "unknown", duration);
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }
}
