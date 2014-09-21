import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

class Delimiter{
	static public void printDelimiter(Class c){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(c+" initializing...");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
}
class InstanceOfTypeCheck{
	public void instanceofTest(){
		Delimiter.printDelimiter(this.getClass());
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
		Delimiter.printDelimiter(this.getClass());
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
		Delimiter.printDelimiter(this.getClass());
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
		Delimiter.printDelimiter(this.getClass());
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
		Delimiter.printDelimiter(this.getClass());
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
// ArraySort Implementation Test
class ArraysSortComparatorSort{
	ArraysSortComparatorSort(){
		Delimiter.printDelimiter(this.getClass());
		System.out.println("Arrays Sort function: Arrays.sort(int[],null).");
		System.out.println("Declaring Comparator for Arrays.sort.");
		
		String str[]={"China","Ireland","Japan","France"};
		
		System.out.println("String array to be sorted:"+Arrays.toString(str));
		System.out.println("Using natural order Comparable in String to compare.");
		Arrays.sort(str, null);
		System.out.println("Arrays after sort:"+Arrays.toString(str));
		
		// Define my own Comparator
		System.out.println("Using Comparator<Object> always return 0.");
		Comparator<Object> cprt = new Comparator<Object>(){
			@Override
			public int compare(Object o1, Object o2) {
				return 0;			
			}
		};
		str= new String[]{"China","Ireland","Japan","France"};
		System.out.println("Original list is:"+Arrays.toString(str));
		Arrays.sort(str,cprt);
		System.out.println("After using Comparator<Object> always return 0:"+Arrays.toString(str) );
		cprt = new Comparator<Object>(){
			@Override
			public int compare(Object o1, Object o2){
				return o1.toString().length()-o2.toString().length();
			}
		};
		System.out.println("Using the Comparator<Object> which is about comparing the toString length: ");
		str= new String[]{"China","Ireland","Japan","France"};
		System.out.println("Original list is:"+Arrays.toString(str));
		Arrays.sort(str,cprt);
		System.out.println("After using Comparator<Object> always return 0:"+Arrays.toString(str) );
	}
}
// Type inference...
// Collections.sort Implementation test
class CollectionsComparatorSort{
	CollectionsComparatorSort(){
		Delimiter.printDelimiter(this.getClass());
	}
}

// Immutable String
class ImmutableString{
	ImmutableString(){
		Delimiter.printDelimiter(this.getClass());
		String a, b, c;
		a= b = c= "hello";
		System.out.println(a+" "+b+" "+c);
		System.out.println("a = bye");
		a = "bye";
		System.out.println("result after \"a\" changed: "+ a+ " "+ b+" "+c);
	}
}

// Mutable Class
class MutableObject{
	MutableObject(){
		Delimiter.printDelimiter(this.getClass());
		Object a, b, c;
		a = b = c = new Object(){
			@Override
			public String toString(){
				return "a";
			}
		};
		System.out.println("a, b, c are initialized as:");
		System.out.println("a.toString():"+a);
		System.out.println("b.toString():"+b);
		System.out.println("c.toString():"+c);
		
		b = new Object(){
			@Override
			public String toString(){
				return "b";
			}
		};
		c = new Object(){
			@Override
			public String toString(){
				return "c";
			}
		};
		System.out.println("a, b, c changed to:");
		System.out.println("a.toString():"+a);
		System.out.println("b.toString():"+b);
		System.out.println("c.toString():"+c);
	}
}

// RecursiveTask
class SortTask extends RecursiveAction{
	// final int[]array, final int lo, final int hi;
	final int array[], lo, hi;
	private int THRESHOLD = 0 ;
	
	SortTask(){
		Delimiter.printDelimiter(this.getClass());
		System.out.println("Array generated locally...");
		Random rd = new Random();
		int []arr =new int [100];
		for(int i=0;i<arr.length;i++)
			arr[i] = rd.nextInt()%100;
		this.lo = 0; this.hi = 100; this.array = arr;
		
		System.out.println("Randomly generated:"+Arrays.toString(arr));
		
	}
	SortTask(int arr[],int lo,int hi){
		this.array = arr;
		this.lo = lo;
		this.hi = hi;
	}
	@Override
	protected void compute() {
		// Implement compute from abstract class
		if(hi - lo <= THRESHOLD){
			sequentiallySort(array, lo, hi );
		}
		else{
			int pivot = partition(array, lo, hi);
			
			System.out.println("After partition, pivot :"+pivot+" lo:"+lo+" hi:"+hi);
			System.out.println("Array after partiion:"+Arrays.toString(array));
			invokeAll(new SortTask(array,lo, pivot), new SortTask(array,pivot+1, hi));
		}
	}
	// partition for qsort
	private int partition(int[]arr, int lo, int hi){
		int pivot = hi-1;
		for(int i=lo;i<pivot;i++){
			if(arr[i] < arr[pivot]){
				swap(arr,lo,i);
				lo++;
			}
		}
		swap(arr,lo,pivot);
		
		return lo;
	}
	// swap arr elements
	private void swap(int[]arr, int i, int j){
		if(i!=j){
			int tmp = arr[i];
			arr[i]= arr[j];
			arr[j]=tmp;
		}
	}

	private void sequentiallySort(final int[]array, final int lo, final int hi){
		// Using Arrays.sort() built-in sortring algorithm
		Arrays.sort(array, lo, hi);
	}
	
}
// Question about Java PassBy Value and final kw test
class PassByValueAndFinal{
	PassByValueAndFinal(){
		Delimiter.printDelimiter(this.getClass());
		System.out.println("Java method is passed by value/value of reference.");
		System.out.println("Change only can be made to Object inner state. And the Objects should be Mutable.");
		System.out.println("Immutable Class like Wrapper Class, and String can't change their inner states");
		
		int []arr =new int[]{1,2,3,4};
		Integer []arrInteger = new Integer[]{1,2,3,4};
		
		System.out.println("Array before passed in:"+Arrays.toString(arr));
		passByReference(arrInteger);
		System.out.println("Array after passed in:"+Arrays.toString(arr));
		
	}
	void passByReference(int[]arr){
		for(int a:arr){
			a= 0;
		}
	}
	void passByReference(Object[]arr){
		for(Object i:arr){
			if(i instanceof Integer){
				i = new Integer(0);
			}
		}
	}
	// final keyword for Object reference
	class FinalReferenceClass{
		public int value;
	}
	void passByReference(final FinalReferenceClass o){
		o.value = 10;
	}
}
// Question about Immutable / Mutable in Java

// Question about Auto-Boxing for array of primitives to array of Wrapper type?

// Exception thrown from methods mandatory should be declared explicitly?

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
		
		// Arrays.sort(T[],Comparator<T>)
		ArraysSortComparatorSort asct = new ArraysSortComparatorSort();
		
		// ImmutableString checking variable declaration and assignment
		ImmutableString is = new ImmutableString();
		
		// Mutable Class Objects 
		MutableObject mtc = new MutableObject();
		
		//PassByValueAndFinal test
		PassByValueAndFinal pbvaf = new PassByValueAndFinal();
		
		// RecursiveAction example
		SortTask st = new SortTask();
		ForkJoinTask<?> fjt = st;
		ForkJoinPool fjp = new ForkJoinPool();
		fjp.submit(fjt);
		fjp.shutdown();
		fjt.join();
		
	}

}
