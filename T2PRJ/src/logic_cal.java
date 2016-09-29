
public class logic_cal {
	public static void main(String[] args) {
		int a = 10, b = 20, c = 30, d = 40;
		if(a++ < b || c++ > d){
			//output
			System.out.println(a+","+b+","+c+","+d);
		}
		if(++a > b && ++c > d)
			System.out.println(a+","+b+","+c+","+d);
		System.out.println(a+","+b+","+c+","+d);
	}
}
