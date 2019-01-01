package Player;

import java.util.ArrayList;

public class Album {

    private String title;

    private ArrayList<Song> songs = new ArrayList<>();

    public Album(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(String title, String artist, double duration) {
        Song song = new Song(title, artist, duration);
        songs.add(song);
        System.out.println(song.getTitle() + " was added to the album!");
    }

    public void addSong(String title, double duration) {
        Song song = new Song(title, duration);
        songs.add(song);
        System.out.println(song.getTitle() + " was added to the album!");
    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println(song.getTitle() + " was added to the album!");
    }

    public void removeSong(String title) {
        int indexOfSong = findSong(title);

        if(indexOfSong < 0) {
            System.out.println(title + " is not in the list!");
        } else {
            songs.remove(indexOfSong);
            System.out.println(title + " was removed from the album!");
        }
    }

    public void removeSong(Song song) {
        int indexOfSong = findSong(song.getTitle());

        if(indexOfSong < 0) {
            System.out.println(title + " is not in the list!");
        } else {
            songs.remove(indexOfSong);
            System.out.println(title + " was removed from the album!");
        }
    }

    public void printSongs() {
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i+1) + " - " + songs.get(i).getTitle() + ".");
        }
    }

    public int findSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(title)) {
                System.out.println(title + " found in " + this.getTitle() + "!");
                return i;
            }
        }
        System.out.println(title + " not found in " + this.getTitle() + "!");
        return -1;
    }
}
