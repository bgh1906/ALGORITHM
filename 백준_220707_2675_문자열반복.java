import java.io.*;
 
public class 백준_220707_2675_문자열반복 {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());        
 
		for (int i = 0; i < T; i++) {
			String[] arr = br.readLine().split(" ");
 
			int R = Integer.parseInt(arr[0]);
 
			for (byte val : arr[1].getBytes()) {
				for (int j = 0; j < R; j++) {
					sb.append((char)val);
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}