import java.io.*;
import java.util.*;
import java.math.BigInteger;
 
public class 백준_220915_10757_큰수AB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger A = new BigInteger(st.nextToken());
		BigInteger B = new BigInteger(st.nextToken());
		
		A = A.add(B);
		
		System.out.println(A.toString());
	}
}