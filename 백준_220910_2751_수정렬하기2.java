import java.io.*;
import java.util.*;

public class 백준_220910_2751_수정렬하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list);

		for (int j = 0; j < N; j++) {
			sb.append(list.get(j)).append('\n');
		}
		System.out.println(sb);
	}
}

//https://www.acmicpc.net/problem/2751
//Collections.sort(list);와 StringBuilder를 통해 시간을 단축시킨다.