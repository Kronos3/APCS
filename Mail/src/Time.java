import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

public class Time {
	private long time;
	private Calendar cal;
	private static String[] months = {
			"January", "February", "March", "April", 
			"May", "June", "July", "August", "September", 
			"October", "November", "December"
	};
	private static String[] days = {
			"Monday", "Tuesday", "Wednesday", "Thursday",
			"Friday", "Saturday", "Sunday"
	};
	
	public Time ()
	{
		this (System.currentTimeMillis());
	}
	
	public Time (long time)
	{
		this.time = time;
		this.cal = Calendar.getInstance();
		cal.setTime(new Date (this.time));
	}
	
	public String toString ()
	{
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
		metaCalc.add(index -> formatToSize.apply((Time.days[index.intValue()])));
		metaCalc.add(index -> formatToSize.apply((Time.months[index.intValue()])));
		metaCalc.add(day -> day.toString());
		metaCalc.add(month -> month.toString());
		metaCalc.add(second -> second.toString());
		
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
