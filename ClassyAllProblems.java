// Classy Problem
// Variable shadowing and method overriding
// 1. Class variables members will not be decided dynamically, which means the variable mentioned in super class code will always behave the same no matther the method is overriden and the variable shadowing happens.
// 2. Non-static Methods inherited from super class will be overriden dynamically based on the reference(run-time type checking)
// 3. Nested method in father class which are overriden in an outer overriden method in child class will surprisely act different.
//    - This is the reason why it's not suggested that potentially overriden methods should be called in super class constructor, which will be implicitly called in child constructor.

class SuperClassy {
	private int member_private = 1;
	public int member_public = 1;
	static public int member_public_static = 1;

	public void printMember() {
		System.out.println("PrintMemeber Testing.....in Super");
		System.out.println("Super print non-static private member:"
				+ this.member_private); // even though this mehtod is called in
										// sub class, the accessed variable
										// still from Super class
		System.out.println("Super print non-static public memeber:"
				+ this.member_public); // even though this mehtod is called in
										// sub class, the accessed variable
										// still from Super class
	}

	// override methods
	public void override() {
		System.out.println("Sub class memeber private:" + this.member_private);
		override_nested();
	}
	public void override_nested(){
		System.out.println("Super class member public nested:"+this.member_public);
	}

	static void print() {
		System.out.println("Print in super statically.");
	}
}

class SubClassy extends SuperClassy {
	private int member_private = 2; // this variable shadowing will not change
									// the overrided method's behaviour
	public int member_public = 2;

	// static public int member_public_static = 2;

	public void printMember() {
		System.out.println("PrintMemeber Testing.....in Sub");
		super.printMember();
		System.out.println("Sub print non-static private member:"
				+ this.member_private);
		System.out.println("Sub print non-static public memeber:"
				+ this.member_public);
	}

	// static void print(){
	// System.out.println("Print in sub statically.");
	// }

	// override methods
	public void override() {
		super.override();
	}
	public void override_nested(){
		System.out.println("Sub class member public nested:"+this.member_public);
	}

}

class ClassyAllProblems {

	public ClassyAllProblems() {
		Delimiter.printDelimiter(this.getClass());
		SuperClassy sc1 = new SubClassy();

		sc1.printMember();

		((SubClassy) sc1).printMember(); // Still will act the same

		// Static Variable couldn't be inherited and dynamically overriding
		SuperClassy superclassy = null;
		SubClassy subclassy = null;
		// Static variable
		System.out.println("superclassy static variable:"
				+ superclassy.member_public_static);
		System.out.println("subclassy static variable:"
				+ ((SuperClassy) subclassy).member_public_static);

		SuperClassy superclassy1 = new SubClassy();
		
		
		
		superclassy1.override();

		// Non-static public variable
		System.out.println("superclassy non-static public variable:"
				+ (superclassy1).member_public_static);
		System.out.println("superclassy non-static public variable:"
				+ ((SubClassy) superclassy1).member_public_static);
		
		((SuperClassy) superclassy1).override();

	}

	public static void main(String[] args) {
		new ClassyAllProblems();
	}
}
