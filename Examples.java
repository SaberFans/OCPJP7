import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;

class Demiliter{
	static public void printDemiliter(Class c){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(c+" initializing...");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
}
class InstanceOfTypeCheck{
	public void instanceofTest(){
		Demiliter.printDemiliter(this.getClass());
		String str = null;
		if(str instanceof Object){
			System.out.println("is object");
		}
		else
			System.out.println("not object");
	}
}
class ConstantPool{
	// Class Constant equal test
	String a = "hello";
	String b = "hello";
	public void testIfEquals(){
		Demiliter.printDemiliter(this.getClass());
		System.out.println("a==b is:"+(a==b));
		System.out.println("a=b is "+ (a=b));
	}
}
// Point Class ex test
class Point{
	private int x;
	Point(int x){
		x = x;  // this assignment has no effect
		this.x = x;
	}
}
// Overloading example 
class Overloading{
	public Overloading(){
		Demiliter.printDemiliter(this.getClass());
		overloading(1.0);
		overload(null);
	}
	// Object type overloading
	public void overload(Object o){
		System.out.println("object o");
	}
	public void overload(Exception o){
		System.out.println("exception o");
	}
	// Compiler allows this ambiguous/duplicate declaration
 	public void overloading(int i){
 		System.out.println("int i");
 	}
	
 	public void overloading(int... i) // int ... will take 0 - .. arugments
 	{
 		System.out.println("int... i");
 	}
 	public void overloading(Integer i){
 		System.out.println("Integer i");
 	}
	public void overloading(Integer... i){
		System.out.println("Integer... i");
	}
 	public void overloading(long i){
 		System.out.println("long i");
 	}
	public void overloading(short i){
		System.out.println("short i");
	}
	public void overloading(float i){
		System.out.println("float i");
	}
	public void overloading(float... i){
		System.out.println("float... i");
	}
	public void overloading(double...i){
		System.out.println("doubel... i");
	}
	public void overloading(double i){
		System.out.println("double i");
	}
}
// Binary Search of Arrays 
class BinarySearch{
	
	public void binarySearch(){
		Demiliter.printDemiliter(this.getClass());
		System.out.println("Sorting array using Arrays.sort()");
		int []a;
		a = new int[]{ 2,2,1,5,4};
		System.out.println("Array to be sorted:"+Arrays.toString(a));
		Arrays.sort(a);
		System.out.println("Array after sorted:"+Arrays.toString(a));
		System.out.println("Using BinarySearch now");
		System.out.println("Search 0 in array: "+Arrays.toString(a));
		System.out.println("Result is:"+Arrays.binarySearch(a, 0));
		System.out.println("Search 3 in array: "+Arrays.toString(a));
		System.out.println("Result is:"+Arrays.binarySearch(a, 3));
		System.out.println("Search 7 in array: "+Arrays.toString(a));
		System.out.println("Result is:"+Arrays.binarySearch(a, 7));
	}
}
// Interface abstract kw
interface Birdie{
	public abstract void fly() throws RuntimeException, FileAlreadyExistsException;
}
// Simple inheritance relationship structure example
class Super{
	public int count = 123;
	Super(){
		System.out.println("super count:"+count);
		 
	}
	 void print(){
		System.out.println("super"+count);
	}
}
class Sub extends Super{
	public int count = 234;
	Sub(){
		System.out.println("Before modifying:");
		System.out.println(count);
		System.out.println("Modify inherited static filed to be 4");
		count = 4;
		System.out.println("After modified count:"+count);
		System.out.println("Super class count:"+super.count);
	}
	void print(){
		System.out.println("sub"+count);
	}
}
class StaticClassStaticMethod{
	public StaticClassStaticMethod(){
		Demiliter.printDemiliter(this.getClass());
		Super sp = new Sub();
		
	}
}
// class mutliple inheritance
interface TobeImplemented{
	public int field = 1;
}
class TobeInherited{
	private int field = 1;
}
class MutlipleInheritance extends TobeInherited implements TobeImplemented{
	MutlipleInheritance(){
		System.out.println("Mutliple inheritance/implements relationship won't allow using the ambiguous reference name.");
		System.out.println(field);
	}
}
// Test Entry
public class Examples {

	public static void main(String[] args) {
		// Constant Pool Instance Declaration
		ConstantPool cpool = new ConstantPool();
		cpool.testIfEquals();
		String a = "hello";
		String b = "hello";
		
		System.out.println("a==b is:" + (a==b));
		
		// Pitfall example: + operator will run 
		// System.out.println("a==b is:"+ a==b);
		
		BinarySearch bs = new BinarySearch();
		bs.binarySearch();
		
		// Instance of Check
		InstanceOfTypeCheck ic = new InstanceOfTypeCheck();
		ic.instanceofTest();
		
		// Class Overloading example
		Overloading ol = new Overloading();
		 
		// Static Method invoking && static fields inheritance
		StaticClassStaticMethod scsm = new StaticClassStaticMethod();
		

	}

}
