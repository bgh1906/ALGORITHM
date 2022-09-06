import java.io.*;
import java.util.*;
 
public class 백준_220805_2798_블랙잭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = BlackJack(arr, N, M);
		System.out.println(answer);
	}
 
	static int BlackJack(int[] arr, int N, int M) {
		int max = 0;

		//배열의 첫번째카드 선택 후 다음 2카드를 모든경우탐색 첫번째 카드 증가 후 반복
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int temp = arr[i] + arr[j] + arr[k];

					//3카드의합이 M이면 반환
					if (M == temp) {
						return temp;
					}
					//3카드의합(temp)이 M보다 작고(넘어가지않는경우) 현재까지 최대값(max)보다 큰경우
					if (max < temp && temp < M) {
						max = temp;
					}
				}
			}
		}
		
		return max;
	}
}

//https://www.acmicpc.net/problem/2798