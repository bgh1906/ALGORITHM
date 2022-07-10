import java.io.*;

public class 백준_220711_2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String cWord = br.readLine();
        for (int i = 0; i < cWord.length(); i++) {
            answer++;
            if (i > cWord.length())
                break;
            switch (cWord.charAt(i)) {
                case 'c' :
                    if (i < cWord.length() - 1) {
                        if (cWord.charAt(i + 1) == '=' || cWord.charAt(i + 1) == '-') {
                            i++;
                        }
                        else
                            break;
                    }
                    break;
                case 'd' :
                    if (i < cWord.length() - 2) {
                        if (cWord.charAt(i + 1) == 'z')
                            if (cWord.charAt(i + 2) == '=')
                                i += 2;
                        else
                            break;
                    }
                    if (i < cWord.length() - 1) {
                        if (cWord.charAt(i + 1) == '-')
                            i++;
                        else
                            break;
                    }
                    break;
                case 'l' :
                    if (i < cWord.length() - 1) {
                        if (cWord.charAt(i + 1) == 'j')
                            i++;
                        else
                            break;
                    }
                    break;
                case 'n' :
                    if (i < cWord.length() - 1) {
                        if (cWord.charAt(i + 1) == 'j')
                            i++;
                        else
                            break;
                    }
                    break;
                case 's' :
                    if (i < cWord.length() - 1) {
                        if (cWord.charAt(i + 1) == '=')
                            i++;
                        else
                            break;
                    }
                    break;
                case 'z' :
                    if (i < cWord.length() - 1) {
                        if (cWord.charAt(i + 1) == '=')
                            i++;
                        else
                            break;
                    }
                    break;
            }
        }
        System.out.println(answer);
    }
}
