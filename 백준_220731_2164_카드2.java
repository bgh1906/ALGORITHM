import java.io.*;
import java.util.*;

public class 백준_220731_2164_카드2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int temp = 0;
        while (list.size() != 1) {
            list.removeFirst();
            temp = list.get(0);
            list.removeFirst();
            list.add(temp);
        }

        System.out.println(list.peek());
    }
}
