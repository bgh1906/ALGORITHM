import java.io.*;
import java.util.*;

public class 백준_220707_2675_문자열반복_수정 {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String word = st.nextToken();

			for (int j = 0; j < word.length(); j++) {
				for (int k = 0; k < R; k++) {
					sb.append(word.charAt(j));
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}