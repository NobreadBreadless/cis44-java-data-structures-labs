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
            head = head.next;

            // If list only has one element, assure that tail is set to null so it doesn't just dangle
            if (head == null) {
                tail = null;
            }
            size --;
            return;

        } else {
            Node previousNode = head;
            Node current = head.next;

            while (current != null) {
                if (current.song.getTitle().equals(title)) {
                    // Skips over the removed node
                    previousNode.next = current.next;

                    if (current == tail) {
                        tail = previousNode;
                    }

                    size --;
                    return;
                }
                previousNode = current;
                current = current.next;
            }
        }
    }

    public void playNext() {
        // If currentNode is null, start from the head.
        // Otherwise, advance to the next node.
        // If you reach the end, loop back to the head.

        if (currentNode == null) {
            currentNode = head;
        } else {
            currentNode = currentNode.next;

            // Handles looping if user reaches the end
            if (currentNode == null) {
                currentNode = head;
            }
        }

        System.out.println("Now Playing '" + currentNode.song.getTitle() + ",' by " + currentNode.song.getArtist());
    }
    
    public void displayPlaylist() {
        
        // Traverse from the head and print each song.
        Node current = head;

        for (int i = 0; i < size; i++) {
            System.out.println((i+1) + "\n\n. '" + current.song.getTitle() + ",' by " + current.song.getArtist() + ".\n\n");
            current = current.next;
        }
    }

    // I added this just for user interface
    // If user wants to remove something from empty playlist typa situation
    public int getSize() {
        return size;
    }
}