import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_220706_11720_숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        String number;

        N = Integer.parseInt(br.readLine());
        number = br.readLine();

        int answer = 0;

        for (int i=0; i<N; i++){
            answer += number.charAt(i) - '0';
        }

        System.out.println(answer);
    }
}

