import java.util.Scanner;
public class Work5_calcu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b;
		String c;
		System.out.println("��������ʽ��������룩��");
		a = sc.nextDouble();
		c = sc.next();
		b = sc.nextDouble();
		if(c.equals("+")){
			System.out.println(a+b);
		}
		else if(c.equals("-"))
			System.out.println(a-b);
		else if(c.equals("*"))
			System.out.println(a*b);
		else if(c.equals("/"))
			System.out.println(a/b);
		sc.close();
	}
}
