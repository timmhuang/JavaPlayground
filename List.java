import java.util.*;
import java.io.*;

public class List {
    private Object[] list;
    private int tail;
    private int capacity;
    private int current;    // iterator index
    private static final int INITIAL_SIZE = 10;
    private static final int RESIZE_MULTIPLIER = 2;

    private void resizeContainer() {
        int newSize = capacity *= RESIZE_MULTIPLIER;
        Object[] newList = new Object[newSize];
        for (int i = 0; i < tail; ++i) {
            newList[i] = list[i];
        }
        list = newList;
    }

    public List() {
        list = new Object[INITIAL_SIZE];
        tail = 0;
        capacity = INITIAL_SIZE;
        current = -1;
    }

    public int size() {
        return tail;
    }

    public int capacity() {
        return capacity;
    }

    public void firstElement() {
        current = 0;
    }

    public Object nextElement() {
        return list[current++];
    }

    boolean hasMoreElements() {
        while (current < tail && list[current] == null) {
            current += 1;
        }
        return current < tail && list[current] != null;
    }

    public void AddToEnd(Object obj) {
        if (tail == capacity) {
            resizeContainer();
        }
        list[tail] = obj;
        tail += 1;
    }

    public void PrintState() {
        System.out.printf("size: %d  capacity: %d\n", tail, capacity);
    }

    public void Print() {
        PrintState();
        System.out.print("[");
        for (int i = 0; i < tail; ++i) {
            System.out.print(list[i].toString());
            if (i + 1 < tail) {
                System.out.print(" ");
            }
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        List li = new List();
        for (int k = 0; k < args.length; ++k) {
            li.AddToEnd(args[k]);
        }

        li.firstElement();
        while (li.hasMoreElements()) {
            System.out.println(li.nextElement().toString());
        }

        li.AddToEnd(new String("HelloAgain!"));
        li.Print();
        li.AddToEnd(new String("Wow!"));
        li.AddToEnd(new String("Awesome!"));
        li.Print();
    }
}