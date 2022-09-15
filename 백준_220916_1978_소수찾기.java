import java.io.*;
import java.util.*;
 
public class 백준_220916_1978_소수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(N != 0) {
			N--;
			boolean isPrime = true;
			int num = Integer.parseInt(st.nextToken());
			
			if (num == 1) {
				continue;
			}

			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				count++;
			}
		}
		System.out.println(count);
	}
}