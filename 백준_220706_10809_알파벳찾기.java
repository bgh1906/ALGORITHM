import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_220706_10809_알파벳찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int arr[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int wordNumber = 0;

        for (int i = 0; i < word.length(); i++){
            wordNumber = word.charAt(i) - 'a';
            if(arr[wordNumber] == -1)
                arr[wordNumber] = i;
        }

        int flag = 0;
        while(flag != 26) {
            System.out.print(arr[flag]+" ");
            flag++;
        }
    }
}