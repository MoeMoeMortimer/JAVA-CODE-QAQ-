import java.util.Scanner;
public class Work15_CircuArea{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		
		System.out.println("*********");
		System.out.println("*1.����     ");
		System.out.println("*2.������ ");
		System.out.println("*3.Բ��     ");
		System.out.println("*********");
		System.out.println("��ѡ��ͼ�Σ�����0�˳�����");
		i = sc.nextInt();
		while(i != 0){
			if(i == 1){
				double len,wid;
				System.out.println("��������γ�����");
				len = sc.nextDouble();
				wid = sc.nextDouble();
				System.out.println("�������Ϊ��");
				System.out.println(len*wid);
			}
			else if(i == 2){
				double a, b, c;
				System.out.println("���������������߳�������Ϊ�Ϸ�����");
				a = sc.nextDouble();
				b = sc.nextDouble();
				c = sc.nextDouble();
				double p = (a+b+c)/2;
				System.out.println("���������Ϊ��");
				System.out.println(Math.sqrt(p*(p-a)*(p-b)*(p-c)));
			}
			else {
				double r;
				double PI = 3.1415;
				System.out.println("������Բ�뾶��");
				r = sc.nextDouble();
				System.out.println("Բ�����Ϊ��");
				System.out.println(PI*r*r);
			}
			System.out.println("*********");
			System.out.println("*1.����     ");
			System.out.println("*2.������ ");
			System.out.println("*3.Բ��     ");
			System.out.println("*********");
			System.out.println("��ѡ��ͼ�Σ�����0�˳�����");
			i = sc.nextInt();
		}
		sc.close();
	}
}
