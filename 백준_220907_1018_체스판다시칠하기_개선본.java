import java.io.*;
import java.util.*;
 
public class 백준_220907_1018_체스판다시칠하기_개선본 {
	public static boolean[][] arr;
	public static int answer = 64; //최대 64칸
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
 
		arr = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			//흰색이면 true 검은색이면 false인 배열값 저장
			for (int j = 0; j < M; j++) {
				
				if (line.charAt(j) == 'W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}

		//시작지점 입력
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				cutChess(i, j);
			}
		}
		System.out.println(answer);
	}

	public static void cutChess(int x, int y) {

		int count = 0;
		//첫번째칸 값 입력
		boolean checkBW = arr[x][y];
 
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {

				//현재 색상이 시작값으로부터 카운트할때 올바른지 체크
				//다른경우 카운트값 증가
				if (arr[i][j] != checkBW) {
					count++;
				}

				//기준색상 변경
				checkBW = (!checkBW);
			}
			//기준색상 변경
			checkBW = !checkBW;
		}

		//count는 초기 색상기준의 카운트값
		//64 - count는 반전한경우의 카운트값
		count = Math.min(count, 64 - count);

		//최소값이 기존보다 작은경우 갱신
		answer = Math.min(answer, count);
	}
}