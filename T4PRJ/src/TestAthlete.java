import java.text.SimpleDateFormat;
import java.util.Date;
public class TestAthlete {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Athlete sp1 = new Athlete("akashi","ÄÐ",16,"nipon","basketball");
		//sp1.age = 22;
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:S");
		String snow = sdf.format(now);
		System.out.println(sp1);
	}
}
