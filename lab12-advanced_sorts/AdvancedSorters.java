import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

    // --- MergeSort ---
    public static <K> void mergeSort(K[] S, Comparator comp) {
        int n = S.length;
        if (n < 2) return; // Base case

        // TODO: Divide
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);

        // TODO: Conquer (recursive calls)
        mergeSort(S1, comp);
        mergeSort(S2, comp);

        // TODO: Combine
        merge(S, S1, S2, comp);
    }

    private static <K> void merge(K[] S, K[] S1, K[] S2, Comparator comp) {
        int i = 0, j = 0, k = 0;
        // TODO: Implement the merge logic from the lecture
        while (i < S1.length && j < S2.length) {
            if (comp.compare(S1[i], S2[j]) <= 0) {
                S[k++] = S1[i++];
            } else {
                S[k++] = S2[j++];
            }
        }

        // TODO: Copy remaining elements of S1 or S2
        // S1 Copy
        while (i < S1.length) {
            S[k++] = S1[i++];
        }

        // S2 Copy
        while (j < S2.length) {
            S[k++] = S2[j++];
        }
    }

    // --- QuickSort ---
    public static <K> void quickSort(K[] S, Comparator comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    private static <K> void quickSort(K[] S, Comparator comp, int a, int b) {
        if (a >= b) return; // Base case

        // TODO: Divide
        int pivotIndex = partition(S, comp, a, b);

        // TODO: Conquer (recursive calls)
        quickSort(S, comp, a, pivotIndex - 1);
        quickSort(S, comp, pivotIndex + 1, b);
    }

    private static <K> int partition(K[] S, Comparator comp, int a, int b) {
        // TODO: Implement partition logic (e.g., Hoare's from lecture)
        // 1. Choose a pivot (e.g., S[a])
        // 2. Set up 'left' and 'right' pointers
        // 3. Loop and swap elements
        // 4. Return the final index of the pivot
        K pivot = S[a];
        int left = a + 1;
        int right = b;

        while (true) {
            while (left <= right && comp.compare(S[left], pivot) < 0) {
                left++;
            }
            while (left <=right && comp.compare(S[right], pivot) > 0) {
                right--;
            }

            if (left >= right) break;

            // Swap right & left
            K temp = S[left];
            S[left] = S[right];
            S[right] = temp;
            left++;
            right--;
        }

        // Put pivot into place
        K temp = S[a];
        S[a] = S[right];
        S[right] = temp;
        return right;
    }
}
