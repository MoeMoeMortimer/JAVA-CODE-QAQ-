
public class Work13_star {
	public static void main(String[] args) {
		int n = 3, star = 1;
		while(n != 0){
			for(int j = n; j > 0; j--)
				System.out.print(" ");
			for(int i = 0; i < star; i++)
				System.out.print("*");
			for(int j = n; j > 0; j--)
				System.out.print(" ");
			System.out.println(); 
			star += 2;
			n--;
		}
		for(int i = 0; i < star; i++)
			System.out.print("*");
		System.out.println(); 
		n = 1;
		star -= 2; 
		while(star != -1){
			for(int j = n; j > 0; j--)
				System.out.print(" ");
			for(int i = 0; i < star; i++)
				System.out.print("*");
			for(int j = n; j > 0; j--)
				System.out.print(" ");
			star -= 2;
			n++;
			System.out.println();
		}
	}
}
