import java.io.*;
import java.util.*;

public class 백준_220709_2908_상수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String firstNum = st.nextToken();
        String secondNum = st.nextToken();

        if (firstNum.length() > secondNum.length()) {
            reverseNum(firstNum);
        } else if(firstNum.length() < secondNum.length()){
            reverseNum(secondNum);
        } else {
            for (int i = firstNum.length() - 1; i >= 0; i--) {
                if (firstNum.charAt(i) > secondNum.charAt(i)) {
                    reverseNum(firstNum);
                    break;
                } else if (firstNum.charAt(i) < secondNum.charAt(i)) {
                    reverseNum(secondNum);
                    break;
                }
            }
        }
    }

    private static void reverseNum(String number) {
        for (int i = number.length() - 1; i >= 0; i--)
            System.out.print(number.charAt(i));
    }
}

//입력값이 3자리로 고정되어있어 입력값의 자릿수가 다른경우를 체크해주는 코드는 필요없다.