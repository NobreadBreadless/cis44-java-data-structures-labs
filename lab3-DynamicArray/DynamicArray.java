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

    public int get(int index) {
        if (index >= 0 && index < size) {
            return this.data[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

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

    public int size() {
        return size;
    }

    public String toString() {
        return Arrays.toString(data);
    }

    //This is for testing
    //I decided to make it a bit more interactive just so it's easier to test
    public static void main(String[] args) {
        DynamicArray numbers = new DynamicArray();

        //Just for testing
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Your current list:\n" + numbers.toString() + "\n");
            System.out.print(
                "What do you want to do?\n" +
                "Enter 'A' for add items\n" +
                "Enter 'G' to get element of a certain index\n" +
                "Enter 'R' to remove item\n" +
                "Enter 'S' to get size\n"
            );

            String ans = scanner.nextLine();

            if (ans.equalsIgnoreCase("a")) {
                System.out.print("Enter number: ");
                int num = scanner.nextInt();
                scanner.nextLine(); // consume newline

                numbers.add(num);

            } else if (ans.equalsIgnoreCase("g")) {
                System.out.print("Enter index: ");
                int index = scanner.nextInt();
                scanner.nextLine(); // consume newline

                System.out.println("Element: " + numbers.get(index));

            } else if (ans.equalsIgnoreCase("r")) {
                System.out.print("Please select index of item you want to remove: ");
                int index = scanner.nextInt();
                scanner.nextLine(); // consume newline

                System.out.println("Removed: " + numbers.remove(index));

            } else if (ans.equalsIgnoreCase("s")) {
                System.out.println("Size: " + numbers.size());

            } else {
                System.out.println("Invalid Input");
                continue;
            }

            System.out.print("Are you done? Y/N: ");
            String done = scanner.nextLine();

            if (done.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.print(numbers.toString());
        scanner.close();
    }
}