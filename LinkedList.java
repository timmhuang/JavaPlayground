import java.io.*;

public class LinkedList {
    ListNode dummy;
    ListNode tail;
    ListNode cur;
    int size;

    public LinkedList() {
        dummy = new ListNode();  // a dummy node pointing to first node
        tail = dummy;
        cur = dummy.next;
        size = 0;
    }

    public void AddToEnd(Object obj) {
        tail.next = new ListNode(obj);
        tail = tail.next;
        size += 1;
    }

    public void firstElement() {
        cur = dummy.next;
    }

    public Object nextElement() {
        if (!hasMoreElements()) {
            return null;
        }
        Object ret = cur.item;
        cur = cur.next;
        return ret;
    }

    public boolean hasMoreElements() {
        return cur != null;
    }

    public void Print() {
        ListNode node = dummy.next;
        while (node != null) {
            System.out.print(node.toString());
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList();
        for (int i = 0; i < args.length; ++i) {
            head.AddToEnd(new String(args[i]));
        }

        head.firstElement();
        while (head.hasMoreElements()) {
            System.out.printf("%s ", head.nextElement());
        }
        System.out.println();
        head.Print();
        System.out.println(head.nextElement());
        head.AddToEnd(new Integer(12345));
        head.Print();
    }
}

class EndOfListException extends Exception {}

class ListNode {
    Object item;
    ListNode next;

    public ListNode() {
        item = null;
        next = null;
    }

    public ListNode(Object obj) {
        item = obj;
        next = null;
    }

    public String toString() {
        String s = " ";
        if (item != null) {
            s = item.toString();
        }
        if (next != null) {
            s += "-> ";
        }
        return s;
    }
}