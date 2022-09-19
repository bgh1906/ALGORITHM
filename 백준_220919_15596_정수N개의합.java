public class 백준_220919_15596_정수N개의합 {
    long sum(int[] a) {
		long ans = 0;
        
		for(int i = 0; i < a.length; i++) {
			ans += a[i];
		}
		return ans;
    }
}