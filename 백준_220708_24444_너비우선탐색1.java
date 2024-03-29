import java.io.*;
import java.util.*;

public class 백준_220708_24444_너비우선탐색1 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Integer>[] list;
    private static int[] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        list = new ArrayList[N+1];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        for(int i = 0; i < list.length; i++) {
            list[i].sort(null);
        }

        bfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int R) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        visited[R] = ++count;
        while(queue.size()!=0) {
            R = queue.poll();
            List<Integer> l = list[R];
            for(int i = 0; i < l.size(); i++) {
                if(visited[l.get(i)]==0) {
                    queue.add(l.get(i));
                    visited[l.get(i)] = ++count;
                }
            }
        }
    }
}