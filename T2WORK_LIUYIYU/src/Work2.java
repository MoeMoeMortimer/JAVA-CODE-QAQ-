import java.util.Scanner;
public class Work2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		num = sc.nextInt();
		if((num & 1) == 1){
			System.out.println("odd");
			if(num%5 == 0)
				System.out.println("can %5");
		}
		else {
			System.out.println("even");
			if(num%4 == 0){
				System.out.println("can %4");
			}
		}
		sc.close();
	}
}
