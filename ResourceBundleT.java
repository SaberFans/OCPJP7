import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleT{
	class EmptyString{
		String a;
		String b;
	}
	public ResourceBundleT() {
		Locale locale = Locale.getDefault();
		ResourceBundle rb ;//= ResourceBundle.getBundle("ReBundle", locale);
		//System.out.println(rb.getObject("MovieName"));
		
		locale = new Locale("en","XX","Rome");
		Locale ie = new Locale("en","IE","Ireland");
		System.out.println(locale.getDisplayName());
		rb = ResourceBundle.getBundle("ReBundle",locale);
		System.out.printf("resour local name: %s %n",rb.getLocale().toString());
		System.out.printf("lang:%s %n",rb.getLocale());
		System.out.println(rb.getObject("MovieName"));
		
		System.out.println("Currency format:");
		System.out.println("locale:"+locale.getDisplayName()+NumberFormat.getCurrencyInstance(Locale.CHINA).format(100000000L));
		Currency ci = Currency.getInstance(Locale.JAPAN);
		System.out.println("Ireland currency symbol:"+ci.getSymbol(Locale.JAPAN));
	
		Locale def = Locale.getDefault();
		System.out.println("def locale name: "+def.getDisplayName());
		rb = ResourceBundle.getBundle("ReBundle",ie);
		System.out.println("locale:"+rb.getLocale());
		
		String format = "hh  'o''clock'";
		
		System.out.println(new SimpleDateFormat(format).format(new Date()));
	}
	public static void main(String[] args) {
		new ResourceBundleT();
	}
}