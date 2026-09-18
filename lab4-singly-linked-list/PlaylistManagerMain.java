import java.util.Scanner;

public class PlaylistManagerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Create Your Playlist!");
        Playlist myPlaylist = new Playlist();
        
        while (true) {
            // Get user input

            System.out.print("Add, Remove, Play Next, or Show List?\nEnter 'X' to exit\n");
            String ans = scanner.nextLine();

            // Adding songs
            if (ans.equalsIgnoreCase("add")) {
                System.out.print("Add a song: ");
                String title = scanner.nextLine();
                System.out.print("Artist name: ");
                String artist = scanner.nextLine();

                Song song = new Song(title, artist);
                myPlaylist.addSong(song);;

            // Removing songs
            } else if (ans.equalsIgnoreCase("remove")) {
                System.out.print("What song do you want to remove?");
                String remove = scanner.nextLine();

                if (myPlaylist.getSize() == 0) {
                    System.out.println("Add songs first to playlist");
                    continue;
                } else {
                    myPlaylist.removeSong(remove);
                }

            // Play song
            } else if (ans.equalsIgnoreCase("play nextadd")) {
                if (myPlaylist.getSize() > 0) {
                    myPlaylist.playNext();
                } else {
                    System.out.println("Please add songs first");
                }

            // Display playlist
            } else if (ans.equalsIgnoreCase("show list")) {
                myPlaylist.displayPlaylist();
            
            } else if (ans.equalsIgnoreCase("x")){
                break;

            } else {
                System.out.println("Not one of the options, please pick again");
            }
        }

        scanner.close();
    }
}
