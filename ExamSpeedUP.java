import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;




import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;




// **注意是import static ！！！
import static java.lang.System.out;

// Q1 Number class cannot be instantiated, because it is an abstract class
class NumberInstantiate {
	Number a;// = new Number();
	// Interger, Float, Double and other concrete classes can be instantiated
	// through different types
	char hextoInt = 0x71;
	int hint = 0x992;
	int x = 'c';
	char c = 1;
	// Premitive types and Wrapper class will do the auto-/un boxing
	// 高精度可以引用低精度，反之则不行。

	// 例如以下两个例子：
	// Hex 十六进制会转换成int 然后转成float
	Float floatnum = new Float(0x71);
	// 由高精度向低精度 转化，会损失精度。理应不支持，并且报错。
	// -->Integer intA = new Integer(0L);
}

// Q4 StringBuffer appends null object
class StringBufferTest {
	final static StringBuffer sb;
	final static Object nullObject = null;
	static {
		sb = new StringBuffer();
		sb.append(nullObject); // string buffer will append 'null' as literal
								// string.!!
	}
}

// Method shadowing
class MethodShadowing {
	public void shadow(Object o) {

	}

	public void shadow(String o) {

	}

	// If the following is not noted,
	// between Object, and String, the most specified type will be chosen for
	// "shadow(null);"
	public void shadow(Integer c) {

	}

	public void shadowing() {
		// shadow(null); this will cause the Ambigous method overloading
	}
}
// Q8
class ClassConstructor{
	public ClassConstructor(int x){
		
	}
	public ClassConstructor() {
		//super();   
		this(1);
	}
}
// Interface, or Class Variable Shadowing Problem
interface X1 {
	int x1 = 0;
}

interface X2 {
	int x1 = 1;
}

public class ExamSpeedUP implements X1, X2 {
	public static void main(String[] args) {
		// Ambiguous Filed reference !!!!!!
		// System.out.println("x1:" + x1);

		// String Buffer Test
		StringBufferTest stbt = new StringBufferTest();
		StringBuilder generalString = new StringBuilder();
		generalString = generalString.append((Object)null);
		System.out.println(generalString);
		
		CollectionOfStudent cofs = new CollectionOfStudent();
	}
}
// Q26 Natural Ordering of Arrays
class Student implements Comparable<Student>{
	int age;
	public Student(int age){
		this.age = age;
	}
	@Override
	public int compareTo(Student o) {
		return (this.age-o.age)>0?1:(this.age==o.age?0:-1);
	}
	@Override
	public String toString() {
		return "Student age:"+this.age;
	}
	 
}
class CollectionOfStudent{
	public CollectionOfStudent() {
		Delimiter.printDelimiter(this.getClass());
		Student[] studs;
		studs = new Student[10];
		Random r = new Random();
		
		for(int i=0;i<10;i++){
			studs[i]= new Student(r.nextInt(20)+1);
		}
		Arrays.sort(studs);
		System.out.println(Arrays.toString(studs));
	}
}
class StudentComparator implements Comparator<Student>{
	int x;
	
	@Override
	public int compare(Student o1, Student o2) {
		
		return 0;
	}

	 
	
}
// Q28
class Generic<T> {
	T[] arr;
	T t_variable;

	public Generic() {
		// // Cannot instantiate array Type T!!
		// // arr = new T[10];
		// // Cannot instantiate Generic Type T!!
		// // t_variable = new T();
	}
}

// Q31 Iterable and Iterator
// Iteratable Interface: Implementing this interface will allow the object to be
// be the target of for-each stm.
interface IterableSUB extends Iterable {

}

interface IteratorSUB<E> extends Iterator<E> {

}
