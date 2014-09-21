import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ScannerTokenizer{
	
	public ScannerTokenizer() {
		Delimiter.printDelimiter(this.getClass());
		String str = "<head>hello</head> <body>bye</body> ";
		Scanner s = new Scanner(str);
		Set<String> set = new TreeSet<>();
		s.useDelimiter("[\\W]");
		while(s.hasNext()){
			set.add(s.next());
		}
		// set.add(null); 
		// Which Collection allows null element to add in
		System.out.println(set);
	}
	public static void main(String[] args) {
		new ScannerTokenizer();
	}
}