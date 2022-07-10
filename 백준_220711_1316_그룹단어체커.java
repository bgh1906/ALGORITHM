import java.io.*;

public class 백준_220711_1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String word;
        int wordArr[];
        int wordGroup;
        int answer = 0;

        for (int TC = 0; TC < N; TC++) {
            word = br.readLine();
            wordArr = new int[26];
            wordGroup = 0;
            for (int i = 0; i < word.length(); i++) {
                wordGroup++;
                wordArr[word.charAt(i) - 'a'] = 1;
                if (i < word.length() - 1) {
                    if (word.charAt(i) == word.charAt(i + 1)) {
                        wordGroup--;
                    }
                }
            }

            int arrSum = 0;
            for (int i = 0; i < 26; i++) {
                arrSum += wordArr[i];
            }

            if (wordGroup == arrSum)
                answer++;
        }

        System.out.println(answer);

    }
}
