import java.io.*;

public class 백준_220719_24416_피보나치수1 {
    static int A, B;
    static int[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        recursion(N);
        dp(N);
        System.out.printf("%d %d", A, B);
    }

    private static int recursion(int n) {
        if (n == 1 || n == 2) {
            A++;
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    private static int dp(int n) {
        memo[1] = memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            B++;
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
