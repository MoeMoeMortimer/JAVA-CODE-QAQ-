import java.util.Scanner;
public class Work16_CircuCal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b;
		String c;
		System.out.println("��������ʽ���������,0 0 0��ʾ��������");
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
			System.out.println("��������ʽ���������,0 0 0��ʾ��������");
			a = sc.nextDouble();
			c = sc.next();
			b = sc.nextDouble();
		}
		sc.close();
	}
}
