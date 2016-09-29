
public class Work14_AtoG {
	public static void main(String[] args) {
		int n = 1, p = 6;
		char c;
		while(n != 8){
			c = (char)('A'+n-1);
			for(int j = p; j > 0; j--)
				System.out.print(" ");
			for(int i = 0; i < 2*n-1; i++)
				System.out.print(c);
			for(int j = p; j > 0; j--)
				System.out.print(" ");
			n++;
			p--;
			System.out.println();
		}
	}
}
