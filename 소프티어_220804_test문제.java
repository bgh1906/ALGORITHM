import java.util.*;
import java.io.*;

public class 소프티어_220804_test문제
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), "-");
        int count = st.countTokens();
        for (int i = 0; i < count; i++) {  
            String word = st.nextToken();
            System.out.print(word.charAt(0));
        }
    }
}