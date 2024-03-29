import java.io.*;
 
public class 백준_220818_9461_파도반수열 {
	public static Long[] seq = new Long[101];
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		seq[0] = 0L;
		seq[1] = 1L;
		seq[2] = 1L;
		seq[3] = 1L;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			sb.append(Padovan(Integer.parseInt(br.readLine()))).append('\n');
		}
		System.out.println(sb);
	}
	
	public static long Padovan(int N) {
		if(seq[N] == null) {
			seq[N] = Padovan(N - 2) + Padovan(N - 3);
		}
		return seq[N];
	}
}