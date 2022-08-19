import java.io.*;
import java.util.*;
 
public class 백준_220819_1912_연속합 {
	
	static int[] arr;
	static Integer[] dp;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = arr[0];
		max = arr[0];
		
		DpSum(N - 1);
		
		System.out.println(max);
	}
	
	static int DpSum(int N) {
		
		if(dp[N] == null) {
			dp[N] = Math.max(DpSum(N - 1) + arr[N], arr[N]);
 
			//max 갱신
			max = Math.max(dp[N], max);
		}
		return dp[N];
	}
}