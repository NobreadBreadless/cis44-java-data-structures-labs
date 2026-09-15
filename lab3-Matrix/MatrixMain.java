import java.util.Scanner;

public class MatrixMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //THE Matrix
        System.out.print("Let's make a matrix!\nEnter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        Matrix matrix = new Matrix(rows, cols);


        //Other Matrix
        System.out.print("Let's make a matrix!\nEnter number of rows: ");
        int rows2 = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols2 = scanner.nextInt();

        Matrix otherMatrix = new Matrix(rows2, cols2);


        //Fill up these matrices
        matrix.populateRandom();
        otherMatrix.populateRandom();

        System.out.println("Your current matrices: ");
        System.out.println(matrix.toString() + "\n" + otherMatrix.toString());

        
        //Add or multiply
        System.out.print("Wanna add them or multiply?: ");
        String ans = scanner.next();

        if (ans.equalsIgnoreCase("Add")) {
            System.out.println(matrix.add(otherMatrix).toString());
        } else if (ans.equalsIgnoreCase("Multiply")) {
            System.out.println(matrix.multiply(otherMatrix));
        } else {
            throw new IllegalArgumentException("Sowwy u can only add or multiply");
        }
    }
}
