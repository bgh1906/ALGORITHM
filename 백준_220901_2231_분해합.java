import java.io.*;

public class 백준_220901_2231_분해합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int M;
		int sum;

		for (int i = 0; i < N; i++) {
			M = i;
			sum = 0;

			while (M != 0) { //M이 0이되면 가장큰 자릿수까지 더한것으로 종료
				sum += M % 10; //1의자리를 더해준다
				M /= 10; //10으로나누어 우로 1칸씩 이동시킨다.
			}

			//i는 생성자가되고 생성자에 각자리수의합인 sum을 더해줄때 N이면 i는 N의 생성자가된다.
			if (sum + i == N) {
				answer = i;
				break;
			}
		}
 
		System.out.println(answer);
	}
}

//https://www.acmicpc.net/problem/2231
//가장 작은 생성자이기때문에 0부터 증가시키며 계산한다.