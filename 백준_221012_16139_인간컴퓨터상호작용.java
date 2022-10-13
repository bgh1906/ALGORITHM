import java.io.*;
import java.util.*;

public class 백준_221012_16139_인간컴퓨터상호작용 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int q = Integer.parseInt(br.readLine());
		int l=s.length();

		int[][] arr = new int[l+1][26];
		arr[1][s.charAt(0)-'a']++;
		for (int i = 2; i <= l; i++) {
			int idx = s.charAt(i - 1) - 'a';

			for (int j = 0; j < 26; j++) {
				int before = arr[i - 1][j];
				arr[i][j] = j == idx ? before + 1 : before;
			}
		}

		StringTokenizer st;
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = st.nextToken().charAt(0) - 'a';
			int start = Integer.parseInt(st.nextToken()) + 1;
			int end = Integer.parseInt(st.nextToken()) + 1;
			bw.append((arr[end][idx] - arr[start - 1][idx]) + "\n");
		}
		bw.close();
		br.close();
	}
}