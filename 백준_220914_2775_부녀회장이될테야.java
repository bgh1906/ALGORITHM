import java.io.*;

public class 백준_220914_2775_부녀회장이될테야 {
	public static int[][] APT = new int[15][15];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		APT_PEOPLE();
		
		int T = Integer.parseInt(br.readLine());
 
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(APT[k][n]).append('\n');
		}
		System.out.println(sb);
	}
 
	//모든 입주자의 경우의수 입주
	public static void APT_PEOPLE() {
		//1 ≤ k, n ≤ 14
		for (int i = 0; i < 15; i++) {
			APT[i][1] = 1;
			APT[0][i] = i;
		}
 
		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
			}
		}
	}
}