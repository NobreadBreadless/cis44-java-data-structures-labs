import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.List; 
 
public class Inventory { 
    private List<Item> items; 

    //Constructor
    public Inventory() { 
        this.items = new ArrayList<>(); 
    } 
    
    // Adds items to Inventory
    public void addItem(Item item) {
        items.add(item);
    } 

    // Prints all items in inventory
    public void display() {
        System.out.println("Your bag or whatever you wanna call it:\n" + items);
    } 

    public void combineItems(String name1, String name2) { 
        boolean found1 = false; 
        boolean found2 = false; 

        Iterator<Item> iter = items.iterator(); 
        while (iter.hasNext()) { 
            Item current = iter.next(); 

            // How do you track which item you found? 
            // How do you remove it safely?
            if (current.getName().equals(name1)) {
                found1 = true;
                iter.remove();
            } else if (current.getName().equals(name2)) {
                found2 = true;
                iter.remove();
            }
        }
        // After the loop, check if both were found. 
        // If so, add the new combined item. 
        // What happens if you add the new item inside the loop?
        // It would crash. ConcurrentModificationException

        if (found1 && found2) {
            items.add(new Item(name1 + name2));
        }
    } 
}