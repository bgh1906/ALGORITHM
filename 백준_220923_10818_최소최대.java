import java.io.*;
import java.util.*;

public class 백준_220923_10818_최소최대 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int index = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[index] = Integer.parseInt(st.nextToken());
			index++;
		}
		
		Arrays.sort(arr);
		System.out.println(arr[0] + " " + arr[N - 1]);
	}
}