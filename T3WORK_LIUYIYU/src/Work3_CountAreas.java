import java.util.Scanner;
public class Work3_CountAreas {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true){
		System.out.println("-----------��ѡ����-----------");
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
		double r;
		System.out.println("������Բ�뾶��");
		r = sc.nextDouble();
		System.out.println("Բ�����Ϊ��");
		System.out.println(Math.PI*r*r);
	}
	public static void juxing(){
		double len,wid;
		System.out.println("��������γ�����");
		len = sc.nextDouble();
		wid = sc.nextDouble();
		System.out.println("�������Ϊ��");
		System.out.println(len*wid);
	}
	public static void lingxing(){
		double len,wid;
		System.out.println("���������ζԽ��߳���");
		len = sc.nextDouble();
		wid = sc.nextDouble();
		System.out.println("�������Ϊ��");
		System.out.println(len*wid/2.0);
	}
}

