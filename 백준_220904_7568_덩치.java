import java.io.*;
import java.util.*;

public class 백준_220904_7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Body[] arr = new Body[N];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //배열값 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Body(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        //현재 사람보다 덩키가 큰사람이있다면 순위+1
        for (int j = 0; j < N; j++) {
            int rank = 1;

            for (int k = 0; k < N; k++) {
                if (arr[j].kg < arr[k].kg && arr[j].cm < arr[k].cm)
                    rank += 1;
            }
            sb.append(rank);
            //마지막에는 공백 미포함
            if (j != N - 1)
                sb.append(" ");
        }
        System.out.println(sb);
    }
}

//사람의 무게와 키 클래스
class Body {
    int kg;
    int cm;

    public Body(int kg, int cm) {
        this.kg = kg;
        this.cm = cm;
    }
}

//https://www.acmicpc.net/problem/7568

