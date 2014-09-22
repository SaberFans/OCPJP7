
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.management.RuntimeErrorException;

// Arrays.asList(T...) and usage of varargs
class ArraysAsList{
	ArraysAsList(){
		Delimiter.printDelimiter(this.getClass());
		System.out.println("Show the usage of Arrays.asList(T...a)");
		System.out.println("Initial a List using array of String");
		String[]str = {"hello","bye"};
		List<String> los = Arrays.asList(str);
		System.out.println("List<String> can't be cast to List<Object>");
		
		
		Object[]integ = {1,2,3,4,5};
		// The usage of varargs in T...
		List<Object> lofint = Arrays.asList((Object[])integ);
		System.out.println("pass arr of Integer as varargs");
		System.out.println("List is"+lofint);
		
		// pass in array as an Object 
		List<Object> lofarr = Arrays.asList((Object)integ);
		System.out.println("pass arr of integer as one object");
		System.out.println("memory address of list is"+lofarr);
		Object []mixed ={new Object(), new String("hello"), new Integer(1)};
		List<Object> lofmix = new ArrayList<>(Arrays.asList(mixed));
		List lf = lofmix;
		for(Object c:lofarr)
			System.out.println(c);
		
		
	}
}
// Array.asList<T...> usage for generic type inference
class TypeInference{
	TypeInference(){
		Delimiter.printDelimiter(this.getClass());
		List<Object> lofO = new ArrayList<>(Arrays.asList(1,"2",new Integer(3)));
		System.out.println("Arrays.asList(T...) will conclude the most common type of the varargs passed in.");
		
		// Run the remove(0) for Arrays.asList(T...) list
		
		opReturnList();
		
		showTypeInference();
	}
	class S implements Comparable<String>{
		@Override
		public int compareTo(String o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	class child1 extends S {

	}
	class child2 extends S{
		
	}
	// show type inference of T...
	void showTypeInference(){
		System.out.println("Type inference in Java:");
		System.out.println("The lowest common parent of type Integer and Float is Object, since Integer, Float not only extends Number but also implemments Comparable");
		System.out.println("The type inference for Integer and Float is Type Object");
		
		List<Object> list = new ArrayList<>(Arrays.asList(new Integer(1),new Float(1)));
		System.out.println("Runtime class of list of integer and float"+	list.getClass());
		
		System.out.println("Enable to do type inference if only there's one lowest common parent available.");
		
		List<S> los = new ArrayList<>(Arrays.asList(new child2(),new child1()));
		System.out.println("Runtime class of list of child1 and child2"+	los.getClass());
	}
	// show Arrays.asList(T...) return is a read-only list
	void opReturnList(){
		System.out.println("Arrays.asList() returns a read-only list");
		System.out.println("Remove(0) on Arrays.asList().");
		int []pia = new int[]{1,2,3};
		Integer [] wi = new Integer[]{1,2,3};
		Object oall = pia;
		oall = wi;
		System.out.println("Using new ArrayList(Arrays.asList()).");
		List<Integer> li = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3})); // Can't cast from int[] to Integer[]
		System.out.println("List before remove the first:"+li);
		li.remove(0);
		System.out.println("List after remove the first:"+li);
		
		System.out.println("Operate remove on Arrays.asList() plain return result");
		List<Integer> l = Arrays.asList(new Integer[]{1,2,3,4});
		try{
			l.remove(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("Unsupported Exception caught in remove operation.");
			System.out.println("FYI. Exception thrown after executed the finally block");
		}
		
	}
}

// ArrayDeque usage
class ArrayDequeTest{
	ArrayDequeTest(){
		Delimiter.printDelimiter(this.getClass());
		System.out.println("Test the use of ArrayDeque.");
		Integer []arr ={1,2,3,4};
		Deque<Integer> dq = new ArrayDeque<>();
		System.out.println("Add List<Integer> as Collection<? extends Integer>.");
		dq.addAll(Arrays.asList((Integer[])arr));
		System.out.println("List before remove:"+dq);
		// ArrayDeque remove
		System.out.println("One element removed:"+dq.remove());
		
		System.out.println("List after remove"+dq);
		Iterator<Integer> it = dq.iterator();
		System.out.println("Remove the left using the iterator.remove()");
		while(it.hasNext()){
			System.out.println("element:"+it.next());
			it.remove();
			
		}
	}
}
// WildCard Type Safe 
class TypeSafeWC{
	public TypeSafeWC() {
		Delimiter.printDelimiter(this.getClass());
		System.out.println("Declaring list of String, list of Object, list of any types");
		List<String> lofStr = new ArrayList<>(); 
		List<Object> lofO = new ArrayList<>();
		List lofany = new ArrayList<>();
		
		//Pass into a TypeSafe type reference
		System.out.println("Pass lof String to List<?>");
		typeSafePass(lofStr);
		System.out.println("Pass lof Object to List<?>");
		typeSafePass(lofO);
		System.out.println("Pass lof raw types to List<?>");
		typeSafePass(lofany);
		
		//Pass in list of any to List<Object> 
		System.out.println("Pass Object types into Object types List");
		typeSafePassAgain(lofany);
		
		// Pass List<> examples into List raw types, should be prohibited
		System.out.println("Pass lof O, lof String, lof raw into Raw types");
		typeSafePassAg(lofStr);
		typeSafePassAg(lofany);
		typeSafePassAg(lofO);
		System.out.println("Raw types should not be used in new code.");
		System.out.println("It's only allowed for compatability.");
	}
	void typeSafePassAg(List l){
		l.add(new Integer(1));
	}
	void typeSafePassAgain(List<Object> l){
		l.add(new Integer(1));
	}
	void typeSafePass(List<?> l){
		
	}
}
// Java built-in primitive Type cast and AutoBoxing/Unboxing
class TypeCastAutoBoxing{
	public TypeCastAutoBoxing() {
		// TODO Auto-generated constructor stub
		Delimiter.printDelimiter(this.getClass());
		System.out.println("Cast char to int");
		int a = '0';
		float f = '0';
		long l = 10L; // 10l
		System.out.println("int a = '0', a="+a);
		System.out.println("float f = '0', f="+f);
	}
}
// String format
class StringFormatEx{
	public StringFormatEx() {
		Delimiter.printDelimiter(this.getClass());
		int a = 10;
		float f = 10.0f;
		double d = 10.0;
		long l = 10l;
		char c = '0';
		
		System.out.println("Using %d, %f, %c for string format");
		System.out.println("%d - byte,short,int,long");
		
		System.out.printf("%1$s %1$14s %1$14.1s","hello");
		
		System.out.printf("%1$f %1$10f %1$10.4f%n",1.0);
		
	}
}
// Pattern and String split
class StringRegex{
	StringRegex(){
		Delimiter.printDelimiter(this.getClass());
		String date = "1-10-2013";
		String res[]= date.split("-");
		String resItself []=date.split(date);
		System.out.println("1-10-2013 split by - :"+Arrays.toString(res));
		System.out.println("1-10-2013 split by itself:"+Arrays.toString(resItself));
		
		date = "2.20.2013";
		System.out.println(date+" split by \".\" :"+Arrays.toString(date.split(".")));
		System.out.println(date+" split by \\\\. :"+Arrays.toString(date.split("\\.")));
		
		Pattern p = Pattern.compile(".");
		System.out.println("Using pattern compile \".\" to split "+date+" :"+Arrays.toString(p.split(date)));
		
	}
}
// Exception catch for non-throw method call
class NonException{
	void tryCatchFinally(){
		try{
		}
		// can be ommited, catch block
		catch(Exception e){
			
		}
		// mandatory finally block
		finally{
			
		}
		System.out.println("outside");
	}
	void noCatchBlock(){
		try{
			throw new RuntimeException();
		}
		finally{
			System.out.println("in finally");
		}
		//System.out.println("outside try-catch-finally");
		// No catch block, code will terminate after finally, just after the exception is thrown out
	}
	void exceptionCatch(){
		try{
			throw new RuntimeException();
		}
		catch(RuntimeException e){
			
		}
		finally{
			System.out.println("in finally");
		}
		System.out.println("outside try-catch-finally");
	}
	
	public NonException() {
		Delimiter.printDelimiter(this.getClass());
		tryCatchFinally();
		exceptionCatch();
	}
}
// Throw Multiple Exception
class MultipleThrow{
	MultipleThrow() throws IOException{
		throwMoreEx();
	}
	
	void throwMoreEx() throws IOException,IllegalStateException{
		// RuntimeException explicitly thrown, don't need to worry about catch block at where it's invoked.
	}
}
// Catch not matching throw in Exception
class ThrowNoMatchCatch{
	void throwtry() throws IOException{
		try {
			Integer.parseInt("ten");
			throw new IOException();
		} 
		catch(NumberFormatException e){
			throw e;
		}
		catch(IllegalStateException e){
			throw new FileAlreadyExistsException("");
		}
		catch(IOException e){
			throw new IOException();
		}
		catch (Exception e) {
			throw e;
		}
	}
	ThrowNoMatchCatch(){
		Delimiter.printDelimiter(this.getClass());
		try{
			throwtry();
		}
		catch(IOException|NumberFormatException e){
			System.out.println(e);
		}
	}
}
// Error throw
// the way how try-catch-finally work the same as Exception
class ThrowError{
	void throwError(){
		throw new Error();
	}
	public ThrowError(){
		Delimiter.printDelimiter(this.getClass());
		try{
			throwError();
		}
		finally{
			
			System.out.println("finally");
		}
		//System.out.println("outside try-catch-finally");
	}
	
}
public class Questions{
	public static void main(String[]arg){
		//ArrayDeque Test
		ArrayDequeTest art = new ArrayDequeTest();
		
		// Arrays.asList(T...) usage demo
		ArraysAsList aal = new ArraysAsList();
		
		// Type inference checking
		TypeInference ti = new TypeInference();
		
		// Type Cast etc
		TypeCastAutoBoxing tcab = new TypeCastAutoBoxing();
		
		StringFormatEx sfe = new StringFormatEx();
		 
		SubOuterClass soc = new SubOuterClass();
		
		//String Regex
		StringRegex sr = new StringRegex();
		
		// Catch Exception flow
		NonException ne = new NonException();
		
		// ThrowError
		ThrowError te = new ThrowError();
		
		// Java 7 Throw doesn't match method throw clause
		ThrowNoMatchCatch tnmc = new ThrowNoMatchCatch();
	}
}