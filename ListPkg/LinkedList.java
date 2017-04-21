package ListPkg;
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

    public Object nextElement() throws NoNextElementException {
        if (!hasMoreElements()) {
            throw new NoNextElementException();
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
}

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