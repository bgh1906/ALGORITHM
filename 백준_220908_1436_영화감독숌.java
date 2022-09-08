import java.io.*;

public class 백준_220908_1436_영화감독숌 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		//1번시리즈인 666부터시작
		int num = 666;
		//N이 1이면 바로 1출력
		int count = 1;


		while(count != N) {
			num++;
			//현재 숫자에 666이 포함되어있는지 확인
			if(String.valueOf(num).contains("666")) {
				count++;
			}
		}

		System.out.println(num);
	}
}

//https://www.acmicpc.net/problem/1436