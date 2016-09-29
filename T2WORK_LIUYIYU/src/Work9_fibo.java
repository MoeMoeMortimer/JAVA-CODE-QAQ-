
public class Work9_fibo {
	public static void main(String[] args) {
		long f[] = new long[55];
		f[1] = 1;
		f[2] = 1;
		for(int i = 3; i <= 50; i++)
			f[i] = f[i-1] + f[i-2];
		for(int i = 1; i <= 50; i++){
			System.out.print(f[i]+" ");
			if((i%10) == 0)
				System.out.println();
		}
	}
}
