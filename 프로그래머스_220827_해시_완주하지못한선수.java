import java.util.*;

class 프로그래머스_220827_해시_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        //map.getOrDefault(player, 0) 값이있다면 가져오고 없다면 0을 가져온다.
        for (String player : participant) 
            map.put(player, map.getOrDefault(player, 0) + 1);

        for (String player : completion) 
            map.put(player, map.get(player) - 1);

        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            //0이 아닌경우 해당인원은 완주못한인원
            //이름이 중복된경우도 해결가능
            if (entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}
