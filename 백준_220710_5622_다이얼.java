import java.io.*;

public class 백준_220710_5622_다이얼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            answer += (word.charAt(i) - 'A') / 3 + 3;
            if (word.charAt(i) == 'S' || word.charAt(i) == 'V' || word.charAt(i) == 'Y' || word.charAt(i) == 'Z')
                answer--;
        }

        System.out.println(answer);
    }
}
