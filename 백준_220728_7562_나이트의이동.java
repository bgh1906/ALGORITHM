import java.io.*;
import java.util.*;
 
public class 백준_220728_7562_나이트의이동 {
    static int[] dx = {-2,-1,2,1,2,1,-2,-1};
    static int[] dy = {1,2,1,2,-1,-2,-1,-2};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int start_x, start_y, end_x, end_y;
    static Queue<KnightLocation> q = new LinkedList<>();
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            start_x = Integer.parseInt(st.nextToken());
            start_y = Integer.parseInt(st.nextToken());
            
 
            st = new StringTokenizer(br.readLine());
            end_x = Integer.parseInt(st.nextToken());
            end_y = Integer.parseInt(st.nextToken());
            
            KnightMove(new KnightLocation(start_x, start_y));
            System.out.println(map[end_x][end_y]);
        }
        
    }
    
    static void KnightMove(KnightLocation d) {
        q.clear();
        visited[d.x][d.y] = true;
        
        q.add(d);
        
        while(!q.isEmpty()) {
            KnightLocation t = q.remove();
            int x1 = t.x;
            int y1 = t.y;
 

            if(x1 == end_x && y1 == end_y) {
                break;
            }
            
 
            for(int i = 0; i < dx.length; i++) {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];
                
                if(x2 >= 0 && x2 < N && y2 >= 0 && y2 < N && !visited[x2][y2]) {
                    q.add(new KnightLocation(x2,y2));
                    visited[x2][y2] = true;
                    map[x2][y2] = map[x1][y1] + 1;
                }
            }
        }
        
    }
 
}
 
class KnightLocation {
    int x;
    int y;
    
    public KnightLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}