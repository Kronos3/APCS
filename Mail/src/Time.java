import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

/**
 * Holds metadata for a given timestamp
 */
public class Time {
	private long timestamp;
	private static String[] months = {
			"January", "February", "March", "April", 
			"May", "June", "July", "August", "September", 
			"October", "November", "December"
	};
	private static String[] days = {
			"Sunday", "Monday", "Tuesday", "Wednesday", 
			"Thursday", "Friday", "Saturday"
	};

	/**
	* Constructs timestamp with the current system time
	*/
	public Time ()
	{
		this.timestamp = System.currentTimeMillis();
	}

	/**
	* String representation of the timestamp
	*/
	public String toString ()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date (this.timestamp));
		int[] dateMeta = {
				Calendar.DAY_OF_WEEK, 
				Calendar.MONTH,
				Calendar.DAY_OF_MONTH,
				Calendar.HOUR,
				Calendar.MINUTE,
				Calendar.SECOND
		};
		
		Function<String, String> formatToSize = in -> in.substring(0, 3);
		ArrayList<Function<Integer, String>> metaCalc = new ArrayList<Function<Integer, String>>();
		metaCalc.add(index -> formatToSize.apply((Time.days[cal.get(index) - 1])));
		metaCalc.add(index -> formatToSize.apply((Time.months[cal.get(index)])));
		metaCalc.add(day -> new Integer(cal.get(day)).toString());
		metaCalc.add(hour -> new Integer(cal.get(hour)).toString());
		metaCalc.add(minute -> new Integer(cal.get(minute)).toString());
		metaCalc.add(second -> new Integer(cal.get(second)).toString());
		
		assert dateMeta.length == metaCalc.size();
		
		return String.format("%s %s %s, %s:%s:%s", 
				metaCalc.get(0).apply(dateMeta[0]),
				metaCalc.get(1).apply(dateMeta[1]),
				metaCalc.get(2).apply(dateMeta[2]),
				metaCalc.get(3).apply(dateMeta[3]),
				metaCalc.get(4).apply(dateMeta[4]),
				metaCalc.get(5).apply(dateMeta[5]));
	}
}
