import java.io.*;
import java.utils.*;

public class LoopSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; ++i) {
            sum += i;
        }
        System.out.println(sum);
    }
}