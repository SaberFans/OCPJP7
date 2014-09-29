import java.util.Scanner;
// By the way, 
// Unchecked means the behavior
// Unchecked throwable types: Error, RuntimeException
// Checked throwable types: Throwable, Exception, Exception sub classes except RTE
public class TryWithResources
{
	void tryWithResources(){
		// Compare to tryBlock, can be on its own.
		try(Scanner s = new Scanner(System.in)){
			System.out.println(s.nextInt());
		}
	}
	void tryBlock(){
		// A try block can be associated with Catch/Finally or both
	}
	public TryWithResources() throws Error {
		// TODO Auto-generated constructor stub
		Delimiter.printDelimiter(this.getClass());
		
		try(Scanner s = new Scanner(System.in)){
			s.close();
			//throw new Error("hello");
		}
		catch(Exception e){
			//throw new Error();
			//throw new Exception();
			
			
		}
		catch(Error e){
			System.out.println("error");
		}
		catch(Throwable t){
			System.out.println("throwable");
		}
		
	}
	
	public static void main(String[] args){
		new TryWithResources();
	}
 
}
