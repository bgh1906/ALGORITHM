import java.io.*;
import java.util.*;

public class 백준_220726_7569_토마토 {
    static int dx[] = { -1, 1, 0, 0, 0, 0 };
    static int dy[] = { 0, 0, -1, 1, 0, 0 };
    static int dz[] = { 0, 0, 0, 0, 1, -1 };

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st; 대체
        String str[] = br.readLine().split(" ");
        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);
        int H = Integer.parseInt(str[2]);


        int map[][][] = new int[N][M][H];
        //map입력시 높이를 가장 외곽 반복문에 배치
        for (int k = 0; k < H; k++)
            for (int i = 0; i < N; i++) {
                str = br.readLine().split(" ");
                for (int j = 0; j < M; j++)
                    map[i][j][k] = Integer.parseInt(str[j]);
            }

        BFS(map, N, M, H);

    }
 
    public static void BFS(int map[][][], int N, int M, int H) {
        Queue<TMT7569Pair> q = new LinkedList<>();
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (map[i][j][k] == 1)
                        q.add(new TMT7569Pair(i, j, k));
                }
            }
        }
 
        while (!q.isEmpty()) {
            TMT7569Pair pair = q.poll();
            for (int i = 0; i < 6; i++) {
                int nextX = pair.x + dx[i];
                int nextY = pair.y + dy[i];
                int nextZ = pair.z + dz[i];
 
                if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= N || nextY >= M || nextZ >= H) {
                    continue;
                }
                if (map[nextX][nextY][nextZ] != 0) {
                    continue;
                }
                map[nextX][nextY][nextZ] = map[pair.x][pair.y][pair.z] + 1;
                q.add(new TMT7569Pair(nextX, nextY, nextZ));
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (map[i][j][k] == 0) {
                        //큐가 끝난이후에도 익지않은 토마토가 있는경우 -1
                        System.out.println(-1);
                        return;
                    }

                    max = Math.max(max, map[i][j][k]);
                }
            }
        }
        System.out.println(max - 1);

    }
}

class TMT7569Pair {
    int x;
    int y;
    int z;

    TMT7569Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

//https://www.acmicpc.net/problem/7569
//bfs사용 : 한번에 여러토마토가 익기때문에 dfs로 풀이 불가
//기존 토마토에서 3차원으로 높이를 계산한 6방탐색을 진행한다.
