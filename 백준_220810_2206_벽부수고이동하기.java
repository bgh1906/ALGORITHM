import java.io.*;
import java.util.*;


public class 백준_220810_2206_벽부수고이동하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //배열로 저장
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }


        Queue<Location> q = new LinkedList<>();
        q.add(new Location(0, 0, 1, false));

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        boolean[][][] visited = new boolean[N][M][2];

        while (!q.isEmpty()) {
            Location loca = q.poll();

            if (loca.i == N - 1 && loca.j == M - 1) {
                System.out.println(loca.cnt);
                return;
            }

            //사방탐색
            for (int d = 0; d < 4; d++) {
                int nextX = loca.i + dx[d];
                int nextY = loca.j + dy[d];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                int nextCnt = loca.cnt + 1;

                if (map[nextX][nextY] == '0'){ // 벽이 아니면
                    if (!loca.destroyed && !visited[nextX][nextY][0]) { // 부신 벽이 여태까지 없었으면
                        q.add(new Location(nextX, nextY, nextCnt, false));
                        visited[nextX][nextY][0] = true;
                    } else if (loca.destroyed && !visited[nextX][nextY][1]){ // 벽을 한번 부신 적이 있으면
                        q.add(new Location(nextX, nextY, nextCnt, true));
                        visited[nextX][nextY][1] = true;
                    }

                } else if(map[nextX][nextY]=='1'){ // 벽이면

                    if (!loca.destroyed){ // 한번도 벽을 부순적이 없다면 부순다
                        q.add(new Location(nextX, nextY, nextCnt, true));
                        visited[nextX][nextY][1] = true;
                    }
                    // 한번 부순 적이 있다면 또 부수고 갈 수 없기 때문에 pass
                }
            }
        }
        //큐가 끝난 시점에서 도착하지 못했다면
        System.out.println(-1);
    }

    static class Location {
        int i;
        int j;
        int cnt;
        boolean destroyed;

        public Location(int i, int j, int cnt, boolean d) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.destroyed = d;
        }
    }
}