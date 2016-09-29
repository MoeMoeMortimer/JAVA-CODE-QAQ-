
public class rever {
	public static void main(String[] args) {
		int i, hun, ten;
		for(i = 1009; i <= 1111; i++){
			hun = i%1000 /100;
			ten = i%100 /10;
			if(i*9  == 9001 + ten*100 + hun*10){
				System.out.println(i);
				break;
			}
		}
	}
}
