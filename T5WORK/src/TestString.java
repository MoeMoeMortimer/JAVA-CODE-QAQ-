import org.omg.Messaging.SyncScopeHelper;

public class TestString {
	public static void main(String[] args) {
		String str = "123456789";
		String sub = str.substring(5, 9);
		System.out.println(sub);
		int a = Integer.parseInt(sub);
		System.out.println(a);
	}
}
