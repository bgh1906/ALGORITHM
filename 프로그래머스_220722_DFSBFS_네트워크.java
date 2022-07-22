class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {//방문한적 없으면
                answer++;
                FindNetwork(visited, computers, i);
            }
        }

        return answer;
    }

    public static void FindNetwork(boolean[] visited, int[][] computers, int index) {
        visited[index] = true;//방문처리
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false && computers[index][i] == 1)
                FindNetwork(visited, computers, i);
        }
    }
}