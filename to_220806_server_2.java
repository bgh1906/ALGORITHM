import java.util.*;

class to_220806_server_2 {
    public int solution(int[] levels) {
        int answer = 0;

        if (levels.length < 4) 
            return -1;
        else {     
            int many = levels.length / 4;

            Arrays.sort(levels);

            answer = levels[levels.length-many];

            return answer;                    
        }
    }
}