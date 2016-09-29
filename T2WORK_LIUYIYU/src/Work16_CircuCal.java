import java.util.Scanner;
public class Work16_CircuCal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b;
		String c;
		System.out.println("请输入算式（逐个输入,0 0 0表示结束）：");
		a = sc.nextDouble();
		c = sc.next();
		b = sc.nextDouble();
		while(true){
			if(c.equals("0"))break;
			if(c.equals("+")){
				System.out.println(a+b);
			}
			else if(c.equals("-"))
				System.out.println(a-b);
			else if(c.equals("*"))
				System.out.println(a*b);
			else if(c.equals("/"))
				System.out.println(a/b);
			System.out.println("请输入算式（逐个输入,0 0 0表示结束）：");
			a = sc.nextDouble();
			c = sc.next();
			b = sc.nextDouble();
		}
		sc.close();
	}
}
