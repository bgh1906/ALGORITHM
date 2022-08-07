import java.io.*;
import java.util.*;
 
public class 백준_220807_1021_회전하는큐 {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> q = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int[] seq = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			int target_idx = q.indexOf(seq[i]);
			int halfNumber;

			//남은 큐가 짝수인지 홀수인지 확인
			if(q.size() % 2 == 0) {
				halfNumber = q.size() / 2 - 1;
			}
			else {
				halfNumber = q.size() / 2;
			}

			if(target_idx <= halfNumber) {
				for(int j = 0; j < target_idx; j++) {
					int temp = q.pollFirst();
					q.offerLast(temp);
					count++;
				}
			}
			else {
				for(int j = 0; j < q.size() - target_idx; j++) {
					int temp = q.pollLast();
					q.offerFirst(temp);
					count++;
				}
			
			}
			q.pollFirst();
		}
		
		System.out.println(count);
	}
}