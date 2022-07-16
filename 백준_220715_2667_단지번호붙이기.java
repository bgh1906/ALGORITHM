import java.io.*;
import java.util.*;

public class 백준_220715_2667_단지번호붙이기 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] map;
    private static int count;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static ArrayList<Integer> result;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        String input;
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        count = 0;
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    Search(i, j);
                    result.add(count);
                }
            }
        }

        result.sort(null);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }

    private static void Search(int x, int y) {
        visited[x][y] = true;
        //사방탐색
        for (int i = 0; i < 4; i++) {
            int dx = x + dr[i];
            int dy = y + dc[i];

            if (dx >= 0 && dy >= 0 && dx < N && dy < N) {
                if (map[dx][dy] == 1 && !visited[dx][dy]) {
                    Search(dx, dy);
                    count++;
                }
            }
        }
    }
}
