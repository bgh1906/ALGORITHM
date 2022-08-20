import java.io.*;
import java.util.*;

public class 백준_220820_1149_RGB거리 {
	static int N;
	static int[][] arr;
	static int[][] price;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][3];
		price = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 배열 생성끝

		for (int i = 1; i <= N; i++) {
			price[i][0] = Math.min(price[i - 1][1], price[i - 1][2]) + arr[i][0];
			price[i][1] = Math.min(price[i - 1][0], price[i - 1][2]) + arr[i][1];
			price[i][2] = Math.min(price[i - 1][0], price[i - 1][1]) + arr[i][2];
		}

		System.out.println(Math.min(price[N][0], Math.min(price[N][1], price[N][2])));
	}
}
