import java.util.*;//just looks cleaner especially cuz I'm using a lot of other java stuff

/*Instructions:

- The ecosystem is a river, modeled as a large array of Animal objects. Each cell can hold a Bear, a Fish, or be null.
- Create an abstract Animal class, and have Bear and Fish extend it.
- In each time step, every animal randomly attempts to move to an adjacent cell or stay put.
- Interaction Rules: If two identical animals collide, a new one is born in a random empty cell. If a bear and fish collide, the fish disappears.
- After each step, provide a text-based visualization of the river (e.g., using 'B' for Bear, 'F' for Fish, and '-' for null).*/


// Step 1: Create the abstract parent class
abstract class Animal {
    public abstract String toString();
}

// Step 2: Create the concrete animal classes
class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

// Main class to run the simulation
public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();

        for (int i = 0; i < riverSize; i++) {
            int randy = random.nextInt(3) + 1;

            if (randy == 1) {
                river[i] = new Bear();
            } else if (randy == 2) {
                river[i] = new Fish();
            } else {
                river[i] = null;
            }
        }
    }

    public void runStep() {
        Animal[] newState = new Animal[river.length];

        ArrayList<Integer> emptyCells = new ArrayList<>();
        for (int i = 0; i < river.length; i++) {
            if (river[i] == null) {
                emptyCells.add(i);
            }
        }

        for (int i = 0; i < river.length; i++) {

            if (river[i] == null) continue;

            int move = random.nextInt(3) - 1;
            int target = i + move;

            if (target < 0 || target >= river.length) {
                target = i;
            }

            if (target == i) {
                newState[i] = river[i];
            } else if (river[target] == null) {
                newState[target] = river[i];
            } else if (river[target].getClass() == river[i].getClass()) {
                newState[target] = river[i];
                if (!emptyCells.isEmpty()) {
                    int spawnPoint = emptyCells.get(random.nextInt(emptyCells.size()));
                    if (river[i] instanceof Bear) {
                        newState[spawnPoint] = new Bear();
                    } else {
                        newState[spawnPoint] = new Fish();
                    }
                    emptyCells.remove(Integer.valueOf(spawnPoint));
                }
            } else {
                if (river[i] instanceof Bear) {
                    newState[target] = river[i];
                }
            }
        }

        river = newState;
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter river size: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        Ecosystem eco = new Ecosystem(size);
        eco.visualize();

        while (true) {
            eco.runStep();
            eco.visualize();

            System.out.print("Wanna continue Yes/No)?: ");
            String ans = scanner.nextLine();
            if (ans.equalsIgnoreCase("yes")) continue;
            else break;
        }
    }
}