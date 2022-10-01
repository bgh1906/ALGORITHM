import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PG_221001_문자열 {
    public String solution(String[] registered_list, String new_id) {
        String answer = "";

        //숫자 추출
        IntStream stream = new_id.chars();
        String id_num = stream.filter((ch)-> (48 <= ch && ch <= 57))
                .mapToObj(ch -> (char)ch)
                .map(Object::toString)
                .collect(Collectors.joining());

        //문자 추출
        String id_word = new_id.substring(0, new_id.length() - id_num.length());

        if (!Arrays.stream(registered_list).anyMatch(s -> s.equals(new_id))) {
            answer = new_id;
        } else {
            if (id_num.length() == 0){
                id_num = "0";
            }

            int num = Integer.parseInt(id_num);
            while (true) {
                num += 1;
                String word = id_word + String.valueOf(num);

                if (!Arrays.stream(registered_list).anyMatch(s -> s.equals(word))) {
                    answer = word;
                    break;
                }
            }
        }

        return answer;
    }
}