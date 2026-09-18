import java.util.Scanner;

public class TextEditorMain {
    public static void main(String[] args) {
        TextEditor text = new TextEditor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("SIMPLE TEXT EDITOR");
        
        // Keep looping text editing until user is done
        while (true) {
            // After entering the input, prompt user 2 options: UNDO or REDO
            System.out.print("What do you want to do? UNDO, REDO, ADD, or STOP? Please type in one of the options provided:\n");
            String ans = scanner.nextLine();
            
            //Loop check user answer
            if (ans.equalsIgnoreCase("undo")) {
                text.undo();
                text.printCurrent();

            } else if (ans.equalsIgnoreCase("redo")) {
                text.redo();
                text.printCurrent();

            } else if (ans.equalsIgnoreCase("ADD")) {
                System.out.print("You are now adding text...\n\n");
                String input = scanner.nextLine();
                text.add(input);
                text.printCurrent();

            } else if (ans.equalsIgnoreCase("stop")) {
                text.printCurrent();
                break;

            } else {
                System.out.println("Not a valid option, pls try again...\n\n");
            }
        }

        scanner.close();
    }
}
