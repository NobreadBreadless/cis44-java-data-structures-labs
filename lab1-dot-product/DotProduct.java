public class DotProduct {
    public static void main(String[] args) {
        //Array size with test value
        int n = 6;
        
        //Creates a and b arrays
        int[] a = new int[n];
        int[] b = new int[n];  
        
        //Computes array c that c[i] = a[i] * b[i]
        int[] c = new int[n];

        //Fill up a and b with random numbers and have c compute the dot products and blah...
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * 10);
            b[i] = (int) (Math.random() * 10);
            c[i] = a[i] * b[i];
        }

        //Print everything
        System.out.println("Array a: " + java.util.Arrays.toString(a));
        System.out.println("Array b: " + java.util.Arrays.toString(b));
        System.out.println("Array c: " + java.util.Arrays.toString(c));
    
    }
}