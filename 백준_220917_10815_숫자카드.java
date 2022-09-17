import java.io.*;
import java.util.*;
 
public class 백준_220917_10815_숫자카드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        //이분탐색시 배열 정렬
        Arrays.sort(cards);
        int M = Integer.parseInt(br.readLine());
 
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sb.append(BinarySearch(cards, N, temp) + " ");
        }

        System.out.println(sb);
    }

    //이분탐색진행
    public static int BinarySearch(int[] cards, int N, int search) {
        int first = 0;
        int last = N - 1;
        int mid = 0;
 
        while (first <= last) {
            mid = (first + last) / 2;
 
            if (cards[mid] == search) {
                return 1;
            }
 
            if (cards[mid] < search) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
 
        return 0;
    }
}
