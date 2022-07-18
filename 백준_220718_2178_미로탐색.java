import java.io.*;
import java.util.*;

public class 백준_220718_2178_미로탐색 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        String input;
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        Search(0,0);
        System.out.println(map[N - 1][M - 1]);

    }

    public static void Search(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = xy[0] + dr[i];
                int nextY = xy[1] + dc[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || visited[nextX][nextY]
                        || map[nextX][nextY] == 0) {
                    continue;
                }
                queue.add(new int[] { nextX, nextY });
                visited[nextX][nextY] = true;
                map[nextX][nextY] = map[xy[0]][xy[1]] + 1;
            }
        }
    }
}
