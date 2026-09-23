import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Inventory list = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Prompt User to add items
            System.out.println("Add items into list(Press 'A')\nDisplay items(Enter 'D')\nCombine items(Enter 'C')\nExit(Enter 'X'):");
            String ans = scanner.nextLine();

            // Handles user input with adding and when they wanna stop
            // Adding stuff
            if (ans.equalsIgnoreCase("a")) {
                System.out.print("Put something in the list: ");
                Item newItem = new Item(scanner.nextLine());
                list.addItem(newItem);


            // Displaying stuff
            } else if (ans.equalsIgnoreCase("d")) {
                list.display();

            // Combining stuff
            } else if (ans.equalsIgnoreCase("c")) {
                System.out.print("Enter item 1: ");
                String item1 = scanner.nextLine();
                System.out.print("Enter item 2: ");
                String item2 = scanner.nextLine();
                list.combineItems(item1, item2);

            //Exit
            } else if (ans.equalsIgnoreCase("x")) {
                break;
            }
        }

        list.display();
        scanner.close();
    }
}
