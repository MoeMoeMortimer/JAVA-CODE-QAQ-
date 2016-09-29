import java.util.Scanner;
public class Work6_rank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score;
		score = sc.nextInt();
		score /= 10;
		switch (score){
			case 10: 
			case 9:System.out.println("A");break;
			case 8:System.out.println("B");break;
			case 7:System.out.println("C");break;
			case 6:System.out.println("D");break;
			default:System.out.println("E");break;
		}
		sc.close();
	}
}
