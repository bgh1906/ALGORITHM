import java.io.*;

public class 백준_220708_1157_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int arr[] = new int[26];

        for (int i = 0; i < word.length(); i++) {
            if('A' <= word.charAt(i) && word.charAt(i) <= 'Z')
                arr[word.charAt(i) - 'A']++;
            else
                arr[word.charAt(i) - 'a']++;
        }

        char answer ='?';
        int maxValue = 0;

        for (int i = 0; i < 26; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                answer = (char) (i + 65);
            }
            else if (arr[i] == maxValue)
                answer = '?';
        }

        System.out.println(answer);
    }
}
