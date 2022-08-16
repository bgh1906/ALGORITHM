import java.io.*;
 
public class 백준_220817_1904_01타일 {
 
	public static int[] dp = new int[1000001];;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
 
		for(int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}
		
		System.out.println(MakeTile(N));
	}
	
	public static int MakeTile(int N) {
		if(dp[N] == -1) {
			dp[N] = (MakeTile(N - 1) + MakeTile((N - 2))) % 15746;
		}
		return dp[N];
	}
 
}