
public class Work11_prime {
	public static void main(String[] args) {
		int prime[] = new int[105];
		int is_p[] = new int[105];
		int p = 0;
		for(int i = 1; i <= 100; i++)
			is_p[i] = 1;
		is_p[1] = 0;
		for(int i = 2; i <= 100; i++)
			if(is_p[i] == 1){
				prime[p++] = i;
				for(int j = i*2; j <= 100; j +=i)
					is_p[j] = 0;
			}
		for(int i = 0; i < p; i++){
			System.out.print(prime[i]+" ");
			if(i!=0 && i%9 == 0)
				System.out.println();
		}
	}
}
