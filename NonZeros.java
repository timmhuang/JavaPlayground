import java.util.*;
import java.io.*;

public class NonZeros {
    public static int[] NonZeros(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] != 0) {
                count += 1;
            }
        }

        int[] result = new int[count];
        int at = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] != 0) {
                result[at] = A[i];
                at += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[args.length];
        System.out.printf("passing [ ");
        for (int i = 0; i < args.length; ++i) {
            input[i] = Integer.parseInt(args[i]);
            System.out.printf("%d ", input[i]);
        }
        System.out.printf("] got back [ ");

        int[] result = NonZeros(input);
        for (int i = 0; i < result.length; ++i) {
            System.out.printf("%d ", result[i]);
        }
        System.out.printf("]\n");
    }
}