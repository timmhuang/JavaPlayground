import java.io.*;

public class MaxHeap {
    private final int INIT_SIZE = 16;
    private final int RESIZE_MULTIPLIER = 2;
    private int[] arr;
    private int size;

    private int leftChild(int i) {
        return i * 2 + 1;
    }

    private int rightChild(int i) {
        return i * 2 + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void resizeContainer() {
        int newSize = arr.length * RESIZE_MULTIPLIER;
        int[] newArr = new int[newSize];
        for (int i = 0; i < arr.length; ++i) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public MaxHeap() {
        arr = new int[INIT_SIZE];
        size = 0;
    }

    public MaxHeap(int[] a) {
        arr = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            arr[i] = a[i];
        }
        size = a.length;
        buildMaxHeap();
    }

    private void buildMaxHeap() {
        for (int i = arr.length / 2; i >= 0; --i) {
            siftDown(i);
        }
    }

    private void siftDown(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int largest = i;
        if (l < size && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < size && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            siftDown(largest);
        }
    }

    private void siftUp(int i) {
        int p = parent(i);
        while (p >= 0 && arr[p] < arr[i]) {
            swap(p, i);
            i = p;
            p = parent(i);
        }
    }

    public void push(int v) {
        if (size == arr.length) {
            resizeContainer();
        }
        arr[size] = v;
        siftUp(size);
        size += 1;
    }

    public void pop() throws RuntimeException {
        if (size == 0) {
            throw new RuntimeException("Empty Heap");
        }
        swap(0, size - 1);
        size -= 1;
        siftDown(0);
    }

    public int top() throws RuntimeException {
        if (size == 0) {
            throw new RuntimeException("Empty Heap");
        }
        return arr[0];
    }

    public void printAll() {
        for (int i = 0; i < size; ++i) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    public static void heapSort(int[] input) {
        MaxHeap mh = new MaxHeap(input);
        for (int i = 0; i < input.length; ++i) {
            input[input.length - 1 - i] = mh.top();
            mh.pop();
        }
    }

    public static void main(String[] args) {
        MaxHeap mh = null;
        if (args.length > 0) {
            int[] a = new int[args.length];
            for (int i = 0; i < args.length; ++i) {
                a[i] = Integer.parseInt(args[i]);
            }
            mh = new MaxHeap(a);
        } else {
            mh = new MaxHeap();
            for (int i = -3; i <= 3; ++i) {
                mh.push(i * 2);
            }
        }
        System.out.println("Max Heap initialized: ");
        mh.printAll();

        mh.push(10);
        System.out.println(mh.top());
        mh.printAll();
        mh.pop();
        System.out.println(mh.top());
        mh.printAll();
        mh.pop();
        mh.pop();
        System.out.println(mh.top());
        mh.printAll();

        System.out.println("\nTesting heapsort with input: ");
        int[] input = new int[10];
        for (int i = 0; i < input.length; ++i) {
            int rand = -25 + (int)(Math.random() * 50);
            input[i] = rand;
            System.out.printf("%d ", input[i]);
        }
        System.out.println();
        System.out.println("Sorting...");
        MaxHeap.heapSort(input);
        System.out.println("Result: ");
        for (int i = 0; i < input.length; ++i) {
            System.out.printf("%d ", input[i]);
        }
        System.out.println();
    }
}