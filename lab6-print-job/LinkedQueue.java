public class LinkedQueue<E> implements Queue<E>{
    // Node class
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    // Linked Queue attributes
    private Node<E> front;
    private Node<E> rear;
    private int size = 0;

    // enqueue() method
    public void enqueue(E e) {
        Node<E> newJob = new Node<E>(e, null);

        if (front == null) {
            front = newJob;
            rear = newJob;
        } else {
            rear.next = newJob;
            rear = newJob;
        }

        size ++;
    }

    // dequeue() method
    public E dequeue() {
        if (front == null) {
            System.out.println("Queue is currently empty");
            return null;
        } else {
            E temp = front.element;
            front = front.next;
            if (front == null) {
                System.out.println("Queue is now empty");
                rear = null;
            }

            size --;
            return temp;
        }
    }

    // peek() method
    public E peek() {
        return front.element;
    }

    // size() method
    public int size() {
        return size;
    }

    // isEmpty() method
    public boolean isEmpty() {
        
    }
}
