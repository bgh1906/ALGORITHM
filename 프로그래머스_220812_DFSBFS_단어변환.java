public class 프로그래머스_220812_DFSBFS_단어변환 {
	public static void main(String[] args) {
		String a = "hit";
		String b = "cog";
		String[] c = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(a, b, c));
	}

	static int answer = 51;// 최대 50글자

	public static int solution(String begin, String target, String[] words) {
		boolean visited[] = new boolean[words.length];
		dfs(begin, target, words, 0, visited);
		return answer == 51 ? 0 : answer;// 51이면 변환실패이므로 0출력
	}

	public static void dfs(String begin, String target, String[] words, int count, boolean[] visited) {
		if (begin.equals(target)) {// 변환이 완료된뒤 최소값 갱신
			if (answer > count)
				answer = count;
			return;
		}

		for (int i = 0; i < words.length; i++) { // 방문한지 체크, 1글자만 차이나는지 체크
			if (!visited[i] && check(begin, words[i])) {
				visited[i] = true;
				dfs(words[i], target, words, count + 1, visited);
				visited[i] = false;
			}
		}
	}

	public static boolean check(String begin, String target) {// 1글자만 차이나는지 체크
		char[] c1 = begin.toCharArray();
		char[] c2 = target.toCharArray();

		int change = 0;
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != c2[i])
				change++;
		}
		if (change == 1)
			return true;

		return false;
	}
}