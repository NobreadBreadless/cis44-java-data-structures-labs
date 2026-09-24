public class Main {
    public static void main(String[] args) {
        LinkedPositionalList<String> itenerary = new LinkedPositionalList<>();

        itenerary.addLast("Paris");
        itenerary.addLast("Grand Canyon");
        itenerary.addLast("Yosemite");
        itenerary.addLast("Taipei 101");

        Position<String> paris = itenerary.first();

        itenerary.addAfter(paris, "Venice");

        System.out.println("Your itenerary:\n");

        // For looop to prove functionality of my beautiful iterator
        for (String stop : itenerary) {
            System.out.println(stop);
        }
    }
}
