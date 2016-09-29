
public class Work8 {
	public static void main(String[] args) {
		double a = 2, b = 1, sum = 0, temp;
		for(int i = 1; i <= 20; i++){
			sum += a/b;
			temp = a;
			a += b;
			b = temp;		
			if((i%10) == 0)
				System.out.println();
		}
		System.out.println(sum);
	}
}
