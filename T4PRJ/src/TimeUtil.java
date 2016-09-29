import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static String getNow() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		return sdf.format(now);
	}
}
