import java.io.*;

public class 백준_220720_2747_피보나치수 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[46];

        arr[0] = 0;
        arr[1] = 1;
        if (n == 0)
            System.out.println(0);
        else if (n == 1)
            System.out.println(1);
        else {
            for (int i = 0; i < n - 1; i++)
                arr[i + 2] = arr[i] + arr[i + 1];
            System.out.println(arr[n]);
        }
    }
}