import java.io.*;
import java.util.*;

public class 백준_220907_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer;
		String line;

		int blackStart = 0;
		int whiteStart = 0;

		for (int k = 1; k <= 8; k++) {
			line = br.readLine();
			for (int l = 1; l <= 8; l++) {
				if (k % 2 == 1 && l % 2 == 1) {
					if (line.charAt(l-1) == 'W')
						whiteStart++;
					if (line.charAt(l-1) == 'B')
						blackStart++;
				}

				if (k % 2 == 1 && l % 2 == 0) {
					if (line.charAt(l-1) == 'B')
						whiteStart++;
					if (line.charAt(l-1) == 'W')
						blackStart++;
				}

				if (k % 2 == 0 && l % 2 == 1) {
					if (line.charAt(l-1) == 'B')
						whiteStart++;
					if (line.charAt(l-1) == 'W')
						blackStart++;
				}

				if (k % 2 == 0 && l % 2 == 0) {
					if (line.charAt(l-1) == 'W')
						whiteStart++;
					if (line.charAt(l-1) == 'B')
						blackStart++;
				}
			}
		}

		answer = N * M - Math.max(whiteStart, blackStart);

		System.out.print(answer);
 
	}
}

//https://www.acmicpc.net/problem/1018
//전체버전 8*8 자르기고려X