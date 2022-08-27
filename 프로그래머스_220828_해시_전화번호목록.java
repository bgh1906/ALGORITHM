import java.util.*;

class 프로그래머스_220828_해시_전화번호목록 {
    public boolean solution(String[] phoneBook) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phoneBook.length; i++)
            map.put(phoneBook[i], i);
        
        for (int i = 0; i < phoneBook.length; i++)
            for (int j = 0; j < phoneBook[i].length(); j++)
                //1글자씩 탐색하면서 해시맵에 존재하는지 확인한다.
                if (map.containsKey(phoneBook[i].substring(0, j)))
                    return false;

        return true;
    }
}
