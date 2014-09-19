// Execution Sequence of Class/Object construction

// Sequence of execution if a object is created:
// 1. Static variable declaration of super class
// 2. Static super class block code execution
// 3. Subclass static variable declaration
// 4. Subclass static block
// 5. Super class general variable declaration
// 6. Super class general block execution
// 7. Super class Constructor
// 8. Subclass general variable declaration
// 9. Subclass general block execution
// 10. Subclass constructor execution

// Sequence of execution if only static method is invoked
// 1. Static variable execution in super class
// 2. Static block in super class
// 3. Subclass(this class) static variable declaration
// 4. Subclass static block
// 5. Static method call

class HelperClass{
	public HelperClass() {
		Demiliter.printDemiliter(this.getClass());
		System.out.println("constructing helper class");
	}
}
class SuperOuterClass{
	//static SuperOuterClass soc = new SuperOuterClass();
	//HelperClass hc = new HelperClass();
	static int[] a ;
	static{
		a = new int[]{1,2,3,4};
		System.out.println("Static block in SuperOuterClass");
	}
	{
		System.out.println("Genenral block in SuperOuterClass");
	}
//	static {
//		System.out.println("Static block 2 in SuperOuterClass");
//	}
	public SuperOuterClass() {
		// Super class method invocation will run in sub class
		Demiliter.printDemiliter(this.getClass());
		System.out.println("Constructing super outer class");
	}
	public void print(){	
		System.out.println("print from super");
	}
}
class SubOuterClass extends SuperOuterClass{
	//static SuperOuterClass soc = new SuperOuterClass();
	static HelperClass hc = new HelperClass();
	static{
		System.out.println("Static block in SubOuterClass");
	}
	{
		System.out.println("Genenral block in SubOuterCLass");
	}
//	static {
//		System.out.println("Static block 2 in Subouterclass");
//	}
	static void staticP(){
		System.out.println("Static method call");
	}
	public SubOuterClass() {
		Demiliter.printDemiliter(this.getClass());
		System.out.println("Constructing sub outer class");
		//soc.print();
	}
	@Override
	public void print() {
		System.out.println("print from subclass");
	}
}

public class ClassInitSequence{
	public static void main(String[] args) {
		// Static mehtod call only triggers the static block to 
		SubOuterClass.staticP();
		
	}
}