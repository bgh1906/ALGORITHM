import java.io.*;
import java.util.*;
 
public class 백준_220802_1966_프린터큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
 
		while (TC-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
 
			for (int i = 0; i < N; i++) {
				list.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}
 
			int count = 0;
			
			while (!list.isEmpty()) {
				int[] front = list.poll();
				boolean isMax = true;
				
				for(int i = 0; i < list.size(); i++) {
					
					if(front[1] < list.get(i)[1]) {
						
						list.offer(front);
						for(int j = 0; j < i; j++) {
							list.offer(list.poll());
						}
						
						isMax = false;
						break;
					}
				}
				
				if(!isMax) {
					continue;
				}
				
				count++;
				if(front[0] == M) {
					break;
				}
			}
 
			sb.append(count).append('\n');
 
		}
		System.out.println(sb);
	}
 
}