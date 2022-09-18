import java.util.*;

class 프로그래머스_220918_2020카카오_성격유형검사하기 {
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        String[][] cbtiType = new String[][]{{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};

        for (int i = 0; i < cbtiType.length; i++) {
            String[] sur = cbtiType[i];
            map.put(sur[0], 0);
            map.put(sur[1], 0);
        }
        
        //점수 데이터 저장
        for (int i = 0; i < choices.length; i++){
            String a = survey[i].substring(0, 1);   //캐릭터타입 첫글자 입력
            String b = survey[i].substring(1);  //2글자이므로 1이후값 = 뒤의 캐릭터입력

            //map을 사용하여 해당 유형에 해당하는 값 더하여 저장
            switch (choices[i]){
                case 1 : map.replace(a, map.get(a) + 3);
                    break;
                case 2 : map.replace(a, map.get(a) + 2);
                    break;
                case 3 : map.replace(a, map.get(a) + 1);
                    break;
                case 4 :
                    break;
                case 5 : map.replace(b, map.get(b) + 1);
                    break;
                case 6 : map.replace(b, map.get(b) + 2);
                    break;
                case 7 : map.replace(b, map.get(b) + 3);
                    break;
            }
        }

        //출력시 타입쌍의 묶음을 확인하여 더 높은 값을 출력 후 더해줌
        for (int i = 0; i < cbtiType.length; i++){
            answer += checkType(map, cbtiType[i][0], cbtiType[i][1]);
        }

        return answer;
    }

    public static String checkType(HashMap<String, Integer> map, String type1, String type2){
        String result = "";

        //두번째 타입이 큰 경우
        if (map.get(type1) < map.get(type2)){
            result = type2;
        }
        //첫번째 타입이 큰 경우
        else if (map.get(type1) > map.get(type2)){
            result = type1;
        }
        //값이 동일한경우 알파벳순서가 빠른것 출력
        else {
            result = type1;
        }

        return result;
    }
}