import java.util.Scanner;
public class Work10_isprime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, flag = 1;
		n = sc.nextInt();
		for(int i = 2; i*i < n; i++)
			if(n%i == 0)
				flag = 0;
		if(flag == 1 && n != 1)
			System.out.println("Yes");
		else
			System.out.print("No");
		sc.close();
	}
}
