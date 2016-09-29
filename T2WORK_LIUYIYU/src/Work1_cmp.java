import java.util.Scanner;
public class Work1_cmp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c, temp;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		if(a > b){
			temp = a;
			a = b;
			b = temp;
		}
		if(a > c){
			temp = a;
			a = c;
			c = temp;
		}
		if(b > c){
			temp = b;
			b = c;
			c = temp;
		}
		sc.close();
		System.out.println(a+","+b+","+c);
	}
}
