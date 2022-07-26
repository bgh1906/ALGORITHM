import java.io.*;
import java.util.*;

public class 백준_220725_7576_토마토 {
    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st; 대체
        String str[] = br.readLine().split(" ");
        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);
 
        int map[][] = new int[N][M];
 
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
 
            }
        }

        BFS(map, N, M);

    }
 
    public static void BFS(int map[][], int N, int M) {
        Queue<TMT7576Pair> q = new LinkedList<>();
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1)
                    q.add(new TMT7576Pair(i, j));
            }
        }
 
        while (!q.isEmpty()) {
            TMT7576Pair TMT7569Pair = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = TMT7569Pair.x + dx[i];
                int nextY = TMT7569Pair.y + dy[i];
 
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (map[nextX][nextY] != 0) {
                    continue;
                }
                map[nextX][nextY] = map[TMT7569Pair.x][TMT7569Pair.y] + 1;
                q.add(new TMT7576Pair(nextX, nextY));
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    //큐가 끝난이후에도 익지않은 토마토가 있는경우 -1
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max - 1);
 
    }
}

class TMT7576Pair {
    int x;
    int y;

    TMT7576Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//https://www.acmicpc.net/problem/7576
//bfs사용 : 한번에 여러토마토가 익기때문에 dfs로 풀이 불가
