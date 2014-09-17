// Execution Sequence of Class/Object construction
class SuperOuterClass{
	//static SuperOuterClass soc = new SuperOuterClass();
	static int[] a ;
	static{
		a = new int[]{1,2,3,4};
		System.out.println("Static block in SuperOuterClass");
	}
	{
		System.out.println("Genenral block in SuperOuterClass");
	}
	static {
		System.out.println("Static block 2 in SuperOuterClass");
	}
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
	static SuperOuterClass soc = new SuperOuterClass();
	static{
		System.out.println("Static block in SubOuterClass");
	}
	{
		System.out.println("Genenral block in SubOuterCLass");
	}
	static {
		System.out.println("Static block 2 in Subouterclass");
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
		SubOuterClass soc = new SubOuterClass();
	}
}