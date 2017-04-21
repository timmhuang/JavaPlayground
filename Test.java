import java.io.*;
import ListPkg.*;

public class Test {
    public static void main(String[] args) {
        LList head = new LList();
        for (int i = 0; i < args.length; ++i) {
            head.AddToEnd(new String(args[i]));
        }

        head.firstElement();
        while (head.hasMoreElements()) {
            try {
                System.out.printf("%s ", head.nextElement());
            } catch (NoNextElementException ex) {
                System.out.printf("Cannot go beyond end of list!");
            }
        }
        System.out.println();
        head.Print();
        try {
            System.out.println(head.nextElement());
        } catch (NoNextElementException ex) {
            System.out.println("Cannot go beyond end of list!");
        }
        head.AddToEnd(new Integer(12345));
        head.Print();
    }
}