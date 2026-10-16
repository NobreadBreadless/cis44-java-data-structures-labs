import java.lang.reflect.Array;
import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        
        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            
            // TODO: Generate a random array and time both algorithms.
            int[] arr = generateRandomArrayWithNegatives(n);

            // Timer
            long start = System.nanoTime();
            int brute = MaxSubarraySolver.bruteForceMaxSum(arr);
            long end = System.nanoTime();
            System.out.println("Brute force: " + (end - start) / 1000000.0 + " ms (sum = " + brute + ")");

            start = System.nanoTime();
            int kadane = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            end = System.nanoTime();
            System.out.println("Kadane: " + (end - start) / 1000000.0 + " ms (sum = " + kadane + ")");

            // Bug checker
            if (brute != kadane) {
                System.out.println("Yeah somethin ain't right gng.");
            }
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        // Implementation provided in previous response
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(201) - 100;
        }

        return arr;
    }
}
