import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};
        
        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            
            // TODO: Call your test methods for Average, Best, and Worst cases.
            runAndTimAllSorts("Avg ", generateRandomArray(n));
            runAndTimAllSorts("Best ", generateSortedArray(n));
            runAndTimAllSorts("Avg ", generateReverseSortedArray(n));
        }
    }
    
    // TODO: Implement the runAndTimAllSorts helper method.
    public static void runAndTimAllSorts(String label, int[] og) {
        int[] copy = Arrays.copyOf(og, og.length);
        long start = System.nanoTime();
        SortingAlgorithms.selectionSort(copy);
        long end = System.nanoTime();
        System.out.println(label + "Selection sort: " + (end - start)/1000000.0 + " ms");

        copy = Arrays.copyOf(og, og.length);
        start = System.nanoTime();
        SortingAlgorithms.insertionSort(copy);
        end = System.nanoTime();
        System.out.println(label + "Insertion sort: " + (end - start)/1000000.0 + " ms");

        copy = Arrays.copyOf(og, og.length);
        start = System.nanoTime();
        SortingAlgorithms.mergeSort(copy);
        end = System.nanoTime();
        System.out.println(label + "Merge sort: " + (end - start)/1000000.0 + " ms");
    }

    public static int[] generateRandomArray(int size) {
        // Implementation provided in previous response
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10);
        }
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        // Implementation provided in previous response
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr [i] = i;
        }
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        // Implementation provided in previous response
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr [i] = size - i;
        }
        return arr;
    }
}