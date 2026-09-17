public class Song {
    String title;
    String artist;
    // Constructor and getters...

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Methods to get song object's title and artist:
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}