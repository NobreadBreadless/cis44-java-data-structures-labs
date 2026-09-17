public class Playlist {
    private static class Node {
        Song song;
        Node next;
        
        // Node constructor...
        Node(Song song, Node next) {
            this.song = song;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    public void addSong(Song song) {
        // Make new Song object
        Node newNode = new Node(song, null);

        // Check if empty
        if (head == null) {
            head = newNode;
            tail = newNode;

        //Check if it has at least one song
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size ++;
    }

    public void removeSong(String title) {
        // Handle two cases: removing the head and removing from elsewhere.
        // Don't forget to update the tail if the last song is removed.

        if (head.song.getTitle().equals(title)) {

        }
    }

    public void playNext() {
        // If currentNode is null, start from the head.
        // Otherwise, advance to the next node.
        // If you reach the end, loop back to the head.
    }
    
    public void displayPlaylist() {
        // Traverse from the head and print each song.
    }
    
}