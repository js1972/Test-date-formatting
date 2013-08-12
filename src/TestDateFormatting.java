import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class TestDateFormatting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    
	    //INPUTS
	    String srcDatetimeAsString = "2013-08-12T17:00:00Z";
        String destTimeZone = "AWST";
	    
	    //Parse the input date-time. Get a calendar instance in the destination time-zone
        //and set its date-time. Format the result.
        
        //If the input contains a Z for UTC time then replace it with the RFC822 specification
        //of +0000. Z$ is a regex to match a Z character if its at end of line.
        System.out.println("Before regex:\t\t" + srcDatetimeAsString);
        srcDatetimeAsString = srcDatetimeAsString.replaceAll("Z$", "+0000");
        System.out.println("After regex:\t\t" + srcDatetimeAsString);
        
	    SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	    Date input = null;
        try {
            input = parser.parse(srcDatetimeAsString);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

	    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(destTimeZone));
	    cal.setTimeInMillis(input.getTime());
	    
	    SimpleDateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	    String formatted = destFormat.format(cal.getTime());

	    System.out.println("Formatted output:\t" + formatted);
	}

}
