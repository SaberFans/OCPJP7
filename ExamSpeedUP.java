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
