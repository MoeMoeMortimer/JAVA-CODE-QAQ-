import java.util.Scanner;
public class Work2_YangHuiTri {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("ÇëÊäÈë½×Êı£º");
		n = sc.nextInt();
		solve(n);
		sc.close();
	}
	public static void solve(int n){
		int[][] a = new int[n][n];
		a[0][0] = 1;
		for(int i = 1; i < n; i++)
			for(int j = 0; j <= i; j++){
				if(j == 0 || i == j){
					a[i][j] = 1;
				}else{
				a[i][j] = a[i-1][j-1] + a[i-1][j]; 
				}
			}
		System.out.println(n+"½×Ñî»ÔÈı½Ç£º");
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= i; j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
	}
}

