import java.io.*;

public class 백준_220717_10872_팩토리얼 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        if (N == 0)
            System.out.println(1);
        else {
            int answer = N;
            for (int i = N-1; i > 1; i--) {
                answer *= i;
            }
            System.out.println(answer);
        }
    }
}
