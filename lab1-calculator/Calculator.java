import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double value = scanner.nextDouble();
        
        //Displays current value
        System.out.println("Current value: " + value);

        while (true) {
            System.out.print("Enter operator (+, -, *, /) or 'exit' to quit: ");
            String operator = scanner.next();
            double nextValue = 0.0;

            if (!(operator.equals("exit"))) {
                System.out.print("Enter another number: ");
                nextValue = scanner.nextDouble();

                if (nextValue == 0 && operator.equals("/")) {
                    System.out.println("Error: Division by zero is not allowed.");
                    System.out.println("Current value: " + value);
                    continue;
                }

                if (operator.equals("+")) {
                    value += nextValue;
                } else if (operator.equals("-")) {
                    value -= nextValue;
                } else if (operator.equals("*")) {
                    value *= nextValue;
                } else if (operator.equals("/")) {
                    value /= nextValue;
                }
                System.out.println("Current value: " + value);

            } else {
                break;
            }
        }

        System.out.println("Final Value: " + value);
        scanner.close();
    }
}