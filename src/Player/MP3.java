package Player;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class MP3 {

    private String name;

    private ArrayList<Playlist> library = new ArrayList<>();

    private boolean power;

    public void setPower() {
        if (power) {
            power = false;
        } else {
            power = true;
        }
    }

    public boolean isPower() {
        return power;
    }

    public ArrayList<Playlist> getLibrary() {
        return library;
    }

    public MP3(String name) {
        this.name = name;
        this.power = false;
    }

    public static void addPlaylist(MP3 mp3, Playlist playlist) {
        mp3.library.add(playlist);
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to shutdown\n" +
                "1 - go to next song\n" +
                "2 - go to previous song\n" +
                "3 - remove this song\n" +
                "4 - print menu options");
    }

    private static void playing(Playlist playlist, MP3 mp3) {
        Scanner scanner = new Scanner(System.in);
        boolean goingForward = true;
        ListIterator<Song> listIterator = playlist.getSongs().listIterator();

        if (playlist.getSongs().isEmpty()) {
            System.out.println("No songs in the playlist");
            return;
        } else {
            System.out.println("Now listening to " + listIterator.next().getTitle());
            printMenu();
        }

        while (mp3.isPower()) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Shutting down...");
                    mp3.setPower();
                    break;

                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now listening to " + listIterator.next().getTitle());
                    } else {
                        System.out.println("Reached the end of the playlist");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now listening to " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        goingForward = true;
                    }
                    break;

                case 3:
                    System.out.println("Song removed");
                    listIterator.remove();
                    break;

                case 4:
                    printMenu();
                    break;

                default:
                    System.out.println("Error, shutting down..");
                    mp3.setPower();
                    break;
            }

        }
    }

    public static void main(String[] args) {
        MP3 iPod = new MP3("iPodX");
        iPod.setPower();

        Album wackRap = new Album("WackRap");
        wackRap.addSong(new Song("GenericRap1", 2.1));
        wackRap.addSong(new Song("GenericRap2", 2.2));
        wackRap.addSong(new Song("GenericRap3", 2.3));
        wackRap.addSong(new Song("GenericRap4", 2.4));

        Album cRap = new Album("cRap");
        cRap.addSong(new Song("cRap1", 2.1));
        cRap.addSong(new Song("cRap2", 2.2));
        cRap.addSong(new Song("cRap3", 2.3));
        cRap.addSong(new Song("cRap4", 2.4));

        Playlist raPlaylist = new Playlist("raPlaylist");
        raPlaylist.addAlbumSongs(wackRap);

        raPlaylist.addASong(cRap, "cRap3");
        raPlaylist.addASong(cRap, "cRap1");
        raPlaylist.addASong(cRap, "cRap2");

        iPod.addPlaylist(iPod, raPlaylist);

        Playlist playlist = iPod.getLibrary().get(0);
        playing(playlist, iPod);

    }
}
