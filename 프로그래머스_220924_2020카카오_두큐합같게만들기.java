import java.util.*;

class 프로그래머스_220924_2020카카오_두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long s1 = 0;
        long s2 = 0;
        long sum;

        for (int i = 0; i < queue1.length; i++) {
            int temp = queue1[i];
            q1.add(temp);
            s1 += temp;
        }

        for (int i = 0; i < queue2.length; i++) {
            int temp = queue2[i];
            q2.add(temp);
            s2 += temp;
        }

        sum = s1 + s2;
        if (sum % 2 == 1)
            return -1;

        sum /= 2;

        int p1 = 0;
        int p2 = 0;
        int limit = queue1.length * 2;
        while (p1 <= limit && p2 <= limit) {
            if (s1 == sum)
                return p1 + p2;

            if (s1 > sum) {
                s1 -= q1.peek();
                s2 += q1.peek();
                q2.add(q1.poll());
                p1++;
            } else {
                s2 -= q2.peek();
                s1 += q2.peek();
                q1.add(q2.poll());
                p2++;
            }
        }
        return -1;
    }
}