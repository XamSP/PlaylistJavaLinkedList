package Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {

    private String title;

    //private ArrayList<Song> songs = new ArrayList<>();

    private LinkedList<Song> songs = new LinkedList<Song>();

    private boolean addInAlphabeticalOrder(Song newSong) {
        ListIterator<Song> songListIterator = songs.listIterator();
        String newSongTitle = newSong.getTitle();

        while(songListIterator.hasNext()) {
            int comparison = songListIterator.next().getTitle().compareTo(newSongTitle);
            if(comparison == 0) {
                // equal, do not add since it's already there
                System.out.println(newSongTitle + " is already included in the playlist");
                return false;
            } else if(comparison > 0) {
                // newSong should appear before this one
                songListIterator.previous();
                songListIterator.add(newSong);
                return true;
            } else if(comparison < 0) {
                // move to next song
            }
        }

        songListIterator.add(newSong);
        return true;

    }

    public Playlist(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }

    public void addASong(Song song) {
        addInAlphabeticalOrder(song);
        System.out.println(song.getTitle() + " was added to the " + this.getTitle() + " playlist!");
    }

    public void addASong(ArrayList<Album> albums, String albumTitle, String songTitle) {
        int indexOfAlbum = findAlbum(albums, albumTitle);

        if(indexOfAlbum < 0) {
            //printed
        } else {
            Album currentAlbum = albums.get(indexOfAlbum);
            int indexOfSongFromAlbum = currentAlbum.findSong(songTitle);
            if (indexOfAlbum < 0){
                //findSong prints output
            } else {
                Song foundSong = currentAlbum.getSongs().get(indexOfSongFromAlbum);
                this.addInAlphabeticalOrder(foundSong);
            }
        }
    }

    public void addASong(Album album, String songTitle) {

        int indexOfSongFromAlbum = album.findSong(songTitle);
        if (indexOfSongFromAlbum< 0){
            //findSong prints output
        } else {
            Song foundSong = album.getSongs().get(indexOfSongFromAlbum);
            addInAlphabeticalOrder(foundSong);
        }

    }

    public void addAlbumSongs(ArrayList<Album> albums, String albumTitle) {
        int indexOfAlbum = findAlbum(albums, albumTitle);

        if(indexOfAlbum < 0) {
            //printed

        } else {
            ArrayList<Song> currentAlbumSongs = albums.get(indexOfAlbum).getSongs();
            for(int i = 0; i < currentAlbumSongs.size(); i++) {
                Song currentSongFromAlbum = currentAlbumSongs.get(i);
                addInAlphabeticalOrder(currentSongFromAlbum);
            }
        }

    }

    public void addAlbumSongs(Album album) {
            ArrayList<Song> currentAlbumSongs = album.getSongs();
            for(int i = 0; i < currentAlbumSongs.size(); i++) {
                Song currentSongFromAlbum = currentAlbumSongs.get(i);
                addInAlphabeticalOrder(currentSongFromAlbum);
            }


    }

    public void removeSong(Song song) {
        int indexOfSong = findSong(song.getTitle());

        if(indexOfSong < 0) {
            //printed
        } else {
            System.out.println(song.getTitle() + " was removed from " + this.getTitle() + "!");
            songs.remove(indexOfSong);
        }
    }

    public void removeSong(String title) {
        int indexOfSong = findSong(title);

        if(indexOfSong < 0) {
            //printed
        } else {
            System.out.println(title + " was removed from " + this.getTitle() + "!");
            songs.remove(indexOfSong);
        }
    }

    public static int findAlbum(ArrayList<Album> albums, String albumTitle) {
        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).getTitle().equals(albums)) {
                System.out.println(albumTitle + " album found!");
                return i;
            }
        }
        System.out.println(albumTitle + " album not found!");
        return -1;
    }

//    public int findSongFromAlbum(Album album, String title) {
//        ArrayList<Song> currentAlbumSongs = album.getSongs();
//        for (int i = 0; i < currentAlbumSongs.size(); i++) {
//            if (currentAlbumSongs.get(i).getTitle().equals(title)) {
//                return i;
//            }
//        }
//        return -1;
//    } useless :P

    public int findSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(title)) {
                System.out.println(title + " found!");
                return i;
            }
        }
        System.out.println(title + " not found!");
        return -1;
    }
}

