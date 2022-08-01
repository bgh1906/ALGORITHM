import java.io.*;
import java.util.*;

public class 백준_220801_11866_요세푸스문제0 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<");

        int temp = 0;
        //마지막출력에는 ", "가 불필요하기때문에 1개남을때까지 돌린다.
        while (list.size() != 1) {
            for (int i = 0; i < K-1; i++) {
                temp = list.poll();
                list.add(temp);
            }
            sb.append(list.peek()).append(", ");
            list.removeFirst();
        }

        //마지막남은 리스트를 출력해준다.
        sb.append(list.poll());
        sb.append(">");

        System.out.println(sb);
    }
}
