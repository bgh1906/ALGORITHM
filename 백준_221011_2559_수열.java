import java.io.*;
import java.util.*;

public class 백준_221011_2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int i = 1;
		int sum = 0;

		while (i <= k)
			sum += arr[i++];

		int max = sum;
		while (i <= n) {
			sum += arr[i]-arr[i-k];
			if (max < sum)
				max = sum;
			i++;
		}
		System.out.println(max);
	}
}
