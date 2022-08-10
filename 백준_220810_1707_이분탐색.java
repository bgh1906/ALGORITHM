import java.io.*;
import java.util.*;

public class 백준_220810_1707_이분탐색 {
	static int V, E;
	static ArrayList<Integer>[] list;
	static int visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());

		for(int tc = 0; tc < K; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			visited = new int[V + 1];
			list = new ArrayList[V + 1];

			for(int i = 0; i < list.length; i++)
				list[i] = new ArrayList<>();

			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());

				//양방향 연결
				list[p1].add(p2);
				list[p2].add(p1);
			}
			Grouping();
		}
	}

	public static void Grouping() {
		Queue<Integer> q = new LinkedList<>();

		for(int i = 1; i < V + 1; i++) {
			if(visited[i] == 0) {
				q.add(i);
				visited[i] = 1;
			}

			while(!q.isEmpty()) {
				int location = q.poll();


				for(int j = 0; j < list[location].size(); j++) {
					//0이면 방문하지 않음 큐에넣는다
					if(visited[list[location].get(j)] == 0) {
						q.add(list[location].get(j));
					}

					//현재 정점과 이어진 정점의 방문값이 같다면 이분그래프가 아니다
					if(visited[list[location].get(j)] == visited[location]) {
						System.out.println("NO");
						return;
					}

					//현재 정점과 연결된 정점을 방문하지 않은경우 1이면 2를 넣고 2면 1을 넣어준다.
					if(visited[location] == 1 && visited[list[location].get(j)] == 0)
						visited[list[location].get(j)] = 2;
					else if(visited[location] == 2 && visited[list[location].get(j)] == 0)
						visited[list[location].get(j)] = 1;
				}
			}
		}
		//큐를 모두 통과하면 이분그래프가 맞다.
		System.out.println("YES");
	}
}