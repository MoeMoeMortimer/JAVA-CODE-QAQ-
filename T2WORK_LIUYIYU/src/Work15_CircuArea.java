import java.util.Scanner;
public class Work15_CircuArea{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		
		System.out.println("*********");
		System.out.println("*1.矩形     ");
		System.out.println("*2.三角形 ");
		System.out.println("*3.圆形     ");
		System.out.println("*********");
		System.out.println("请选择图形（输入0退出）：");
		i = sc.nextInt();
		while(i != 0){
			if(i == 1){
				double len,wid;
				System.out.println("请输入矩形长，宽：");
				len = sc.nextDouble();
				wid = sc.nextDouble();
				System.out.println("矩形面积为：");
				System.out.println(len*wid);
			}
			else if(i == 2){
				double a, b, c;
				System.out.println("请输入三角形三边长（必须为合法）：");
				a = sc.nextDouble();
				b = sc.nextDouble();
				c = sc.nextDouble();
				double p = (a+b+c)/2;
				System.out.println("三角形面积为：");
				System.out.println(Math.sqrt(p*(p-a)*(p-b)*(p-c)));
			}
			else {
				double r;
				double PI = 3.1415;
				System.out.println("请输入圆半径：");
				r = sc.nextDouble();
				System.out.println("圆形面积为：");
				System.out.println(PI*r*r);
			}
			System.out.println("*********");
			System.out.println("*1.矩形     ");
			System.out.println("*2.三角形 ");
			System.out.println("*3.圆形     ");
			System.out.println("*********");
			System.out.println("请选择图形（输入0退出）：");
			i = sc.nextInt();
		}
		sc.close();
	}
}
