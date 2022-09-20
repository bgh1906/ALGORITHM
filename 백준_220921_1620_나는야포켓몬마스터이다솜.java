import java.io.*;
import java.util.*;

public class 백준_220921_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> numMap = new HashMap<>();
        HashMap<String, Integer> nameMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            numMap.put(i, name);
            nameMap.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            String input = br.readLine();
            if (isNum(input)){
                sb.append(numMap.get(Integer.parseInt(input))+"\n");
            } else {
                sb.append(nameMap.get(input)+"\n");
            }
        }

        System.out.println(sb);
    }

    //해당입력값이 숫자인지 판별하는메서드
    public static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}