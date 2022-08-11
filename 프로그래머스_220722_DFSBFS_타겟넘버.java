class 프로그래머스_220722_DFSBFS_타겟넘버 {
    private static int answer = 0;
    public int solution(int[] numbers, int target) {
        findTargetNumber(numbers, target, 0, 0);

        return answer;
    }

    public static void findTargetNumber(int[] numbers, int target, int node, int result) {
        if (node == numbers.length) {
            if (result == target)
                answer++;
            return;
        }

        findTargetNumber(numbers, target, node + 1, result + numbers[node]);
        findTargetNumber(numbers, target, node + 1, result - numbers[node]);
    }
}