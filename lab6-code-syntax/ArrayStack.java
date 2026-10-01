public class ArrayStack<E> implements Stack<E> {
    // t represents top index
    private int t = -1;
    private E[] data;

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return t++;
    }

    public boolean isEmpty() {
        return t == -1;
    }

    public void push (E e) {
        // Some cool stuff I found 
        // ++t pre-increments so just in case it's empty, we increment from -1 to 0 before pushing that new element
        data[++t] = e;
    }

    public E pop() {
        if (!(isEmpty())) {
            E item = data[t];
            data[t] = null;
            t--;
            return item;
        } else {
            return null;
        }
    }

    public E top() {
        if (!(isEmpty())) {
           return data[t];
        } else {
            return null;
        }
    }
}
