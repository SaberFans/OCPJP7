import java.util.Arrays;

class StringIndexFrom{
	public StringIndexFrom() {
		Delimiter.printDelimiter(this.getClass());
		String t = "";
		 
		System.out.println(t.indexOf("1"));
	}
}
class StringConversion{
	public StringConversion() {
		// Convert from Integer
		String s1 = "";
		int i1 = Integer.valueOf(s1);
		
		// Convert to String
		Integer i2 = 10;
		String s2 = String.valueOf(i2);
		
	}
}
class StringMatch{
	public StringMatch() {
		String[] str = {"hello 1","bye 2"};
		String p = "^hello\\s\\d";
		for(String s:str){
			if(s.matches(p))
				System.out.println(s + "matches "+ p);
		}
	}
}
class StringSplit{
	public StringSplit() {
		// Split the string
		Delimiter.printDelimiter(this.getClass());
		String quote = " w w";
		String []ar, s;
		System.out.println("Split the string:\""+quote+"\" by '\\s*' ");
		s = quote.split("\\s*");
		for(String st:s){
			System.out.println(st+"\\");
		}
		// Usage of Regex like \\s* working on " w w"
		// => [,,w,,w]
		// \\s* means 0 or more space will always split the given string, 
		// and split them into smaller piece.
		
		// ** FYI.
		// If the delimiter matches at the first character of the source string, 
		// the source string will split into \, the rest...\ substrings.
		
		System.out.println("Split the string:"+"\" w x z\" by ' w|x|z'");
		quote = " w x z";
		s = quote.split(" w|x|z");
		for(String st:s){
			System.out.println(st+"\\");
		}
	}
}
public class StringProcessor{
	public static void main(String[] args) {
		StringIndexFrom sif = new StringIndexFrom();
		
		StringSplit ss = new StringSplit();
		
		StringMatch sm = new StringMatch();
	}
	
}