import java.util.*;

class 프로그래머스_220821_DFSBFS_아이템줍기 {
    static int x, y;
    static List<Rect> rectList;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] rectangle, int character_x, int character_y, int item_x, int item_y) {
        int answer;
        int[][] map = new int[102][102];
        rectList = new ArrayList<>();
        for (int[] i : rectangle) {
            int start_x = i[0] * 2;
            int start_y = i[1] * 2;
            int end_x = i[2] * 2;
            int end_y = i[3] * 2;

            for (int y = start_y; y <= end_y; y++) {
                for (int x = start_x; x <= end_x; x++) {
                    map[y][x] = -1;
                }
            }
            rectList.add(new Rect(start_x, start_y, end_x, end_y));
        }

        answer = Search_bfs(map, character_x * 2, character_y * 2, item_x * 2, item_y * 2);
        return answer;
    }
    static int Search_bfs(int[][] map, int x, int y, int next_x, int next_y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y, 1});
        map[y][x] = 1;  // 방문처리
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];
            int move = p[2];

            if (px == next_x && py == next_y)
                return (move / 2);

            for (int i=0; i<4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(map[ny][nx] < 0 && Check(nx,ny)) {   //방문한적없고 외곽인경우
                    map[ny][nx] = move+1;
                    q.add(new int[] {nx, ny, move+1});
                }
            }
        }
        return -1;
    }

    //외곽체크
    static boolean Check(int x, int y) {
        for (Rect r : rectList) {
            if (r.x1 < x && r.y1 < y && r.x2 > x && r.y2 > y)
                return false;
        }
        return true;
    }

    static class Rect{
        int x1, x2, y1, y2;

        public Rect(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}