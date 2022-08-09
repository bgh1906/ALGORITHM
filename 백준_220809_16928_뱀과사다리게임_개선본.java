import java.io.*;
import java.util.*;

public class 백준_220809_16928_뱀과사다리게임_개선본 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[] visited;
    static int[] upDown;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[101];
        upDown = new int[101];

        //사다리와 뱀 데이터 삽입
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            upDown[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        SnakeAndLadderGame_BFS();

    }

    public static void SnakeAndLadderGame_BFS () {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = 1;

        while (!q.isEmpty()) {
            int location = q.poll();

            //100에 도착
            if (location == 100) {
                System.out.println(visited[100] - 1);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = location + i;

                //범위를 벗어난 경우
                if (next > 100) {
                    continue;
                }

                //방문한적있으면 패스
                if (visited[next] != 0) {
                    continue;
                }

                //도착위치에 사다리나 뱀이 있는지 확인
                if (upDown[next] != 0) {
                        //있는경우
                        //사다리나 뱀을 타고 이동한위치를 방문한지 확인
                        if (visited[upDown[next]] == 0) {
                            q.offer(upDown[next]);
                            visited[upDown[next]] = visited[location] + 1;
                        }
                    }
                    //없는경우
                    else {
                        q.offer(next);
                        visited[next] = visited[location] + 1;
                    }
            }
        }
    }
}
