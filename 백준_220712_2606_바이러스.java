import java.io.*;
import java.util.*;

public class 백준_220712_2606_바이러스 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Integer>[] list;
    private static int[] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new int[N+1];
        list = new ArrayList[N+1];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
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

        bfs(1);

        int answer = 0;
        //i = 2 부터시작하는 이유는 1번 pc는 감염시작 pc로 고정이기때문이다.
        for(int i = 2; i < visited.length; i++) {
            if (answer < visited[i])
                answer = visited[i];
        }

        //방문한 순서에서 -1을 해주는 이유는 1번 pc가 감염시킨 컴퓨터이기 때문에 전체 감염 pc에서 1번 pc를 제외하고 출력한다.
        System.out.println(answer - 1);
        br.close();
    }

    private static void bfs(int startCom) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startCom);
        visited[startCom] = ++count;
        while(queue.size()!=0) {
            startCom = queue.poll();
            List<Integer> l = list[startCom];
            for(int i = 0; i < l.size(); i++) {
                if(visited[l.get(i)]==0) {
                    queue.add(l.get(i));
                    visited[l.get(i)] = ++count;
                }
            }
        }
    }
}
