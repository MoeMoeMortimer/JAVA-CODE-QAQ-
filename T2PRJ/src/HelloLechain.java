import java.util.Scanner;
public class HelloLechain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����������Ҫ���������𣿣�YES/NO��");
		String a = sc.next();
		if(a.equals("YES")){
			System.out.println("Welcome, super big hentai~~!");	
		}
		else if(a.equals("NO"))
			System.out.println("�����ǵ�����~~");
		sc.close();
	}
}
