import java.io.*;
import java.util.*;

public class 백준_220909_2750_수정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		for (int j = 0; j < N; j++) {
			System.out.println(arr[j]);
		}
	}
}

//https://www.acmicpc.net/problem/2750