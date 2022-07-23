import java.io.*;

public class 백준_220723_2749_피보나치수3 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int pisano = 1500000;
        long size = Long.parseLong(br.readLine()) % pisano;

        long[] num = new long[pisano + 1];

        num[0] = 0;
        num[1] = 1;

        for(int i = 2; i <= pisano; i++) {
            num[i] = (num[i - 1] + num[i - 2]) % 1000000;
        }

        System.out.print(num[(int)size]);
    }
}