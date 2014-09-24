interface ThrowIF{
	void print() throws Exception;
}
interface ThrowIFSUB extends ThrowIF{
	void print() throws RuntimeException;
}
abstract class ThrowAS implements ThrowIF{
	public void print() throws ArithmeticException{
		
	}
}
class EmptyThrow{
	public EmptyThrow() {
		// TODO Auto-generated constructor stub
		Delimiter.printDelimiter(this.getClass());
		
	}
}


public class OverridingThrowClause{
	
	public static void main(String[] args) {
		
	}
}