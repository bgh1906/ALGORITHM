import java.io.*;
import java.util.*;

public class 백준_220803_10866_덱 {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Integer> q = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;

		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push_front":
				q.offerFirst(Integer.parseInt(st.nextToken()));
				break;

			case "push_back":
				q.offer(Integer.parseInt(st.nextToken()));
				break;

			case "pop_front" :
				Integer item = q.poll();
				if(item == null) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(item).append('\n');
				}
				break;

			case "pop_back" :
				Integer item2 = q.pollLast();
				if(item2 == null) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(item2).append('\n');
				}
				break;

			case "size":	
				sb.append(q.size()).append('\n');
				break;
				
			case "empty":
				if(q.isEmpty()) {
					sb.append(1).append('\n');
				}
				else {
					sb.append(0).append('\n');
				}
				break;
				
			case "front":
				Integer ite = q.peek();
				if(ite == null) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(ite).append('\n');
				}
				break;
				
			case "back":
				Integer it = q.peekLast();
				if(it == null) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(it).append('\n');
				}
				break;
			}
		}
		System.out.println(sb);
	}
}