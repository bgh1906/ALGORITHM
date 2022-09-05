import java.io.*;
import java.util.*;

public class 백준_220905_2869_달팽이는올라가고싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer;

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        //마지막 이동을 뺀뒤 위치까지 도달하는 일자 계산
        answer = (V-A) / (A-B);

        //나머지가있어서 한번 더 이동해야 하는경우
        if (answer * (A-B) < V-A)
            answer++;

        //처음에 V-A를 해준것 다시 1추가
        System.out.println(answer+1);
    }
}

//https://www.acmicpc.net/problem/2869

