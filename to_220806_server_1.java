class to_220806_server_1 {
    public int solution(String s) {
        int answer = 0;
        int max = -1;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i+1) && s.charAt(i+1) == s.charAt(i+2)
            && max < Integer.parseInt(String.valueOf(s.charAt(i)))) {                
                max = Integer.parseInt(String.valueOf(s.charAt(i)));
            }
        }
        if (max == -1)
            return -1;
        else {
            answer = max*100 + max*10 + max;
            return answer;
        }
    }
}