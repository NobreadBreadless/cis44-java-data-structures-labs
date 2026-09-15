import java.util.*;

public class DynamicArray {
    private static final int INITIAL_CAPACITY = 5;
    private int[] data;

    //Tracks current size
    private int size = 0;

    //Constructor
    public DynamicArray() {
        this.data = new int[INITIAL_CAPACITY];
    }

    //Creates new list double the size of the old one and copies elements over
    private void resize() {
        int[] data = new int[this.data.length * 2];

        for (int i = 0; i < this.data.length; i++) {
            data[i] = this.data[i];
        }

        this.data = data;
    }

    //public methods
    public void add(int element) {
        if (size != this.data.length) {
            this.data[size] = element;
            size++;
        } else {
            resize();
            this.data[size] = element;
            size++;
        }
    }

    //Gets item from specific index
    public int get(int index) {
        if (index >= 0 && index < size) {
            return this.data[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    //Remove item
    public int remove(int index) {
        if (index >= 0 && index < size) {

            int removed = this.data[index];

            for (int i = index; i < size - 1; i++) {
                this.data[i] = this.data[i + 1];
            }

            //Just makes sure the last index of the list is empty
            this.data[size - 1] = 0;

            size--;

            return removed;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    //Gets size
    public int size() {
        return size;
    }

    //Just a toString method
    public String toString() {
        return Arrays.toString(data);
    }
}