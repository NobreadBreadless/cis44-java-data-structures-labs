import java.util.Scanner;

public class DynamicArrayMain{
    public static void main(String[] args) {
        DynamicArray numbers = new DynamicArray();

        //Just for testing really
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
