import java.io.*;
import java.math.BigInteger;

public class 백준_220724_10826_피보나치수4 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BigInteger arr[];
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new BigInteger[n + 1];

        if (n == 0) {
            System.out.print(0);
        }
        else if (n == 1) {
            System.out.print(1);
        }
        else {
            arr[0] = BigInteger.ZERO;
            arr[1] = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                arr[i] = arr[i - 2].add(arr[i - 1]);
            }
            System.out.print(arr[n]);
        }
    }
}

//10000까지 입력값을 받아 BigInteger타입을 사용한다.