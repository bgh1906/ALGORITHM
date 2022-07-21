import java.io.*;
import java.util.*;

public class 백준_220721_2748_피보나치수2 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long arr[];
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new long[n + 1];

        if (n == 0) {
            System.out.print(0);
        }
        else if (n == 1) {
            System.out.print(1);
        }
        else {
            Arrays.fill(arr, -1);
            arr[0] = 0;
            arr[1] = 1;
            System.out.print(Fibo(n));
        }
    }

    private static long Fibo(int n) {
        if (arr[n] == -1)
            arr[n] = Fibo(n - 1) + Fibo(n - 2);
        return arr[n];
    }
}

//90까지 입력값을 받아 long타입을 사용한다.