import java.util.Scanner;
public class TestCountAreas {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.println("-----------��ѡ����---------");
		System.out.println("1.Բ��   2.����    3.����  4.�˳�");
		int select =  sc.nextInt();
		switch(select){
		case 1:Circle();break;
		case 2:juxing();break;
		case 3:lingxing();break;
		case 4:System.exit(0);
		default:
			System.out.println("���벻�Ϸ�������������");
			}
		}
	}
	public static void Circle(){
		Scanner sc = new Scanner(System.in);
		double r;
		System.out.println("������Բ�뾶��");
		r = sc.nextDouble();
		System.out.println("Բ�����Ϊ��");
		System.out.println(Math.PI*r*r);
		//sc.close();
	}
	public static void juxing(){
		Scanner sc = new Scanner(System.in);
		double len,wid;
		System.out.println("��������γ�����");
		len = sc.nextDouble();
		wid = sc.nextDouble();
		System.out.println("�������Ϊ��");
		System.out.println(len*wid);
		//sc.close();
	}
	public static void lingxing(){
		Scanner sc = new Scanner(System.in);
		double len,wid;
		System.out.println("���������ζԽ��߳���");
		len = sc.nextDouble();
		wid = sc.nextDouble();
		System.out.println("�������Ϊ��");
		System.out.println(len*wid/2.0);
		//sc.close();
	}
}
