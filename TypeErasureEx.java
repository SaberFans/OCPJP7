import java.lang.reflect.Array;
import java.util.*;
class UncheckedWarning {
	public UncheckedWarning() {
		// Potential Heap Pollution
		List l = new ArrayList<>();
		List<String> x = l;
		l.add(0, new Integer(1));
		String str = x.get(0);
	}
}
class VaragsEx{
	// Array of generic List<T>
	void takeGenericList(List<String>... lists){  // potential heap pollution from parameterized Varags
		Object[] a = lists;  // Valid 
		a [0] = Arrays.asList(1);
		String str = lists[0].get(0); // Class cast exception run-time
		
	}
	void takeVaragsOfList(){
		System.out.println("empty");
	}
	<T> void takeVaragsOfList(T...a){
		System.out.println("T...");
	}
	<T> void takeVaragsOfList(List<T>...lists ){
		List[] a = lists;
		System.out.println("list<T>...");
	}
	public VaragsEx() {
		List<String> l1 = Arrays.asList("hello","bye");
		List<String> l2 = new ArrayList<>(Arrays.asList("hello"));
		// call the default non-generic method
		this.takeVaragsOfList();
		// call List<T> generic method
		this.<String>takeVaragsOfList();
		// call <T> generic method
		this.<String>takeVaragsOfList("bye");
		
		// FYI without non-generic method
		// List<T> will be called before <T>
	}
}
public class TypeErasureEx {
	public static void main(String[] args) {
		new VaragsEx();
	}
}