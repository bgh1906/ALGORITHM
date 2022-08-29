import java.util.*;

class 프로그래머스_220829_해시_위장 {
    public int solution(String[][] clothes) {
        //옷의 종류별로 구분
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        //모든 조합 계산하기
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;
        
        while(it.hasNext())
            answer *= it.next().intValue() + 1;

        //아무옷도 입지 않는경우 제외
        return answer - 1;
    }
}
