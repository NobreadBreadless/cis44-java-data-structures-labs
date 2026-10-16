public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     */


    /* Brute force
    Primitive operation count:
    * -inner loop body (sum += arr[j], comparison, possible assignment) is a constant number of steps. We'll call this constant 'c'
    * -inner loop runs n times when i=0, n-1 times when i = 1, etc., and one time when i = n-1
    * total inner runs:n(n+1)/2
    * total work: c(n^2 + n)/2
    * total n^2 temr dominates as n grows, thus alg is O(n^2)
    */
    public static int bruteForceMaxSum(int[] arr) {
        // TODO: Implement the O(n^2) brute-force algorithm.
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     */


    /* Kadane
    Primitve operation count
    * loop runs n-1 times
    * each pass does constan num of steps: 1 addition, 2 math.max, 2 assignments. We'll call this constant 'c' again
    * total work: c(n-1) plus a few setups
    * grows in proportion to n, so alg is O(n)
    */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        // TODO: Implement the O(n) Kadane's Algorithm.
        int current = arr[0];
        int best = arr[0];
        for (int i = 1; i < arr.length; i++) {
            current = Math.max(current + arr[i], arr[i]);
            best = Math.max(best, current);
        }

        return best;
    }
}
