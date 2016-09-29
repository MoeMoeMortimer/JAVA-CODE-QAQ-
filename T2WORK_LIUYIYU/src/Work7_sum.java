import java.util.Scanner;
public class Work7_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, n, sum = 0;
		System.out.println("«Î ‰»Îa");
		a = sc.nextInt();
		System.out.println("«Î ‰»În");
		n = sc.nextInt();
		int ans[]=new int[n];
		ans[0] = a;
		sum = a;
		for(int i = 1; i < n; i++){
			sum = sum*10+a;
			ans[i] = ans[i-1] + sum;
		}
		sc.close();
		System.out.println(ans[n-1]);
	}
}
