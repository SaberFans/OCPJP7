
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

// Arrays.asList(T...) and usage of varargs
class ArraysAsList{
	ArraysAsList(){
		Demiliter.printDemiliter(this.getClass());
		System.out.println("Show the usage of Arrays.asList(T...a)");
		System.out.println("Initial a List using array of String");
		String[]str = {"hello","bye"};
		List<String> los = Arrays.asList(str);
		
		Object[]integ = {1,2,3,4,5};
		// The usage of varargs in T...
		List<Object> lofint = Arrays.asList((Object[])integ);
		System.out.println("pass arr of Integer as varargs");
		System.out.println("List is"+lofint);
		
		List<Object> lofarr = Arrays.asList((Object)integ);
		System.out.println("pass arr of integer as one object");
		System.out.println("memory address of list is"+lofarr);
		 
		
	}
}
// Array.asList<T...> usage for generic type inference
class TypeInference{
	TypeInference(){
		Demiliter.printDemiliter(this.getClass());
		System.out.println("Show the type inference example.");
		List<Object> lofO = new ArrayList<>(Arrays.asList(1,"2",new Integer(3)));
		System.out.println("Arrays.asList(T...) will conclude the most common type of the varargs passed in.");
		
		// Run the remove(0) for Arrays.asList(T...) list
		
		opReturnList();
	}
	// show Arrays.asList(T...) return is a read-only list
	void opReturnList(){
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
		finally{
			System.out.println("Unsupported Exception caught in remove operation.");
			System.out.println("FYI. Exception thrown after executed the finally block");
		}
		
	}
}

// ArrayDeque usage
class ArrayDequeTest{
	ArrayDequeTest(){
		Demiliter.printDemiliter(this.getClass());
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
public class Questions{
	public static void main(String[]arg){
		//ArrayDeque Test
		ArrayDequeTest art = new ArrayDequeTest();
		
		// Arrays.asList(T...) usage demo
		ArraysAsList aal = new ArraysAsList();
		
		// Type inference checking
		TypeInference ti = new TypeInference();
	}
}