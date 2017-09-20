import java.util.GregorianCalender;
import java.util.Date;
public class Hello {
    public static void main(String[] args) {
	GregorianCalender myCalender = new GregorianCalender(1995,1,20);
        Date myDate = new Date();
        myDate = myCalender.getTime();
 
	System.out.println(myDate);

    }
}
