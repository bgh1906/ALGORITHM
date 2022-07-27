import java.util.*;

public class 백준_220727_1697_숨박꼭질 {
    static int N;
    static int K;
    //자바의 배열선언
    static int[] visited = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
        } else {
            Search(N);
        }
    }

    static void Search(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    System.out.println(visited[temp]);
                    return;
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[temp] + 1;
                }
            }
        }
    }
}

//https://www.acmicpc.net/problem/1697
//최단경로 bfs사용