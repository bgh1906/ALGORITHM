import java.io.*;
import java.util.*;

public class 백준_220714_1260_DFS와BFS {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static List<Integer>[] list;
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

		dfs(R);

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < visited.length; i++) {
			for (int j = 1; j < visited.length; j++) {
				if (visited[j] == i) {
					sb.append(j).append(" ");
				}
			}
		}

		sb.append("\n");

		//값 초기화
		count = 0;
		visited = new int[N+1];
		bfs(R);

		for(int i = 1; i < visited.length; i++) {
			for (int j = 1; j < visited.length; j++) {
				if (visited[j] == i) {
					sb.append(j).append(" ");
				}
			}
		}
		
		System.out.println(sb);
		br.close();
	}
	
	private static void dfs(int R) {
		visited[R] = ++count;
		List<Integer> l = list[R];
		for(int i = 0; i < l.size(); i++) {
			if(visited[l.get(i)]==0) {
				dfs(l.get(i));
			}
		}
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