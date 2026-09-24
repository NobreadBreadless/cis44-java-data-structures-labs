import java.util.Iterator;
// You'll need a Position interface
// In Position file

public class LinkedPositionalList<E> implements Iterable<E> {
    // --- Nested Node Class (implements Position) ---
    private static class Node<E> implements Position<E> {
        // ... element, prev, next pointers and methods ...
        // I modified prev and next to be Node<E> just so I don't see the "unchecked type" warning
        private E element;
        private Node<E> prev;
        private Node<E> next;

        // Constructor
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        // Get element
        public E getElement() {
            return element;
        }

        // Get Prev & Next
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }

        // Set Element, Prev, & Next
        public void setElement(E e) { element = e; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n;}
    }
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        // ... constructor to create sentinel nodes ...
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.setNext(trailer);
    }
    
    // A way to safely hand back the node of a position
    // Kind of like a translator and a safety check
    private Node<E> validate(Position<E> p) {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException();
        } else {
            return (Node<E>) p;
        }
    }

    // ... Implement all the Positional List methods ...
    // 1. first() method
    public Position<E> first() {
        return (header.getNext() == trailer ? null : header.getNext());
    }

    // 2. last() method
    public Position<E> last() {
        return (trailer.getPrev() == header ? null : trailer.getPrev());
    }

    // 3. before(p) method
    public Position<E> before(Position<E> p) {
        Node<E> node = validate(p);
        return (node.getPrev() == header ? null : node.getPrev());
    }

    // 4. after(p) method
    public Position<E> after(Position<E> p) {
        Node<E> node = validate(p);
        return (node.getNext() == trailer ? null : node.getNext());
    }

    // 5. addFirst(e) method
    public Position<E> addFirst(E e) {
        Node<E> successor = header.getNext();
        Node<E> newNode = new Node<E>(e, header, successor);
        header.setNext(newNode);
        successor.setPrev(newNode);
        size ++;
        return newNode;
    }

    // 6. addLast(e) method
    public Position<E> addLast(E e) {
        Node<E> predec = trailer.getPrev();
        Node<E> newNode = new Node<E>(e, predec, trailer);
        trailer.setPrev(newNode);
        predec.setNext(newNode);
        size ++;
        return newNode;
    }

    // 7. addBefore(p, e) method
    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node;
        Node<E> newNode = new Node<E>(e, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size ++;
        return newNode;
    }

    // 8. addAfter(p, e) method
    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        Node<E> predecessor = node;
        Node<E> successor = node.getNext();
        Node<E> newNode = new Node<E>(e, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size ++;
        return newNode;
    }

    // 9. set(p, e) method
    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E oldElement = node.getElement();
        node.setElement(e);
        return oldElement;
    }

    // 10. remove(p) method
    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> successor = node.getNext();
        Node<E> predecessor = node.getPrev();
        
        successor.setPrev(predecessor);
        predecessor.setNext(successor);

        E somethin = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);

        size --;

        return somethin;
    }

    // --- Nested Iterator Class ---
    private class ElementIterator implements Iterator<E> {
        Position<E> cursor = first(); // Start at the first element
        
        public boolean hasNext() {
            return cursor != null;
        }
        
        public E next() {
            // Store the element at the current cursor
            // Advance the cursor to the next position using after()
            // Return the stored element
            E element = cursor.getElement();
            cursor = after(cursor);
            return element;
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
}
