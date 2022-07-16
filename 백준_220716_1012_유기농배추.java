import java.io.*;
import java.util.*;

public class 백준_220716_1012_유기농배추 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int T;
    private static int M;
    private static int N;
    private static int K;
    private static int[][] map;
    private static int count;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int TC = 0; TC < T; TC++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            count = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        Search(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void Search(int x, int y) {
        visited[x][y] = true;
        //사방탐색
        for (int i = 0; i < 4; i++) {
            int dx = x + dr[i];
            int dy = y + dc[i];

            if (dx >= 0 && dy >= 0 && dx < M && dy < N) {
                if (map[dx][dy] == 1 && !visited[dx][dy]) {
                    Search(dx, dy);
                }
            }
        }
    }
}
