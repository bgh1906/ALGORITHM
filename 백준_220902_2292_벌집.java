import java.io.*;

public class 백준_220902_2292_벌집 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int range = 2;
 
		if (N == 1) {
			System.out.print(1);
		}
 
		else {
			while (range <= N) {
				range = range + (6 * count);
				count++;
			}
			System.out.print(count);
		}
	}
}