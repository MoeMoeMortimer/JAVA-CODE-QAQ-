import java.util.Scanner;
public class Work3_CountAreas {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true){
		System.out.println("-----------请选择功能-----------");
		System.out.println("1.圆形   2.矩形    3.菱形  4.退出");
		int select =  sc.nextInt();
		switch(select){
		case 1:Circle();break;
		case 2:juxing();break;
		case 3:lingxing();break;
		case 4:System.exit(0);
		default:
			System.out.println("输入不合法，请重新输入");
			}
		}
	}
	public static void Circle(){
		double r;
		System.out.println("请输入圆半径：");
		r = sc.nextDouble();
		System.out.println("圆形面积为：");
		System.out.println(Math.PI*r*r);
	}
	public static void juxing(){
		double len,wid;
		System.out.println("请输入矩形长，宽：");
		len = sc.nextDouble();
		wid = sc.nextDouble();
		System.out.println("矩形面积为：");
		System.out.println(len*wid);
	}
	public static void lingxing(){
		double len,wid;
		System.out.println("请输入菱形对角线长：");
		len = sc.nextDouble();
		wid = sc.nextDouble();
		System.out.println("菱形面积为：");
		System.out.println(len*wid/2.0);
	}
}

