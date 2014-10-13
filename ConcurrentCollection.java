import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ConcurrentCollection {
	// Unsafe operation on collection
	void unsafeCollection() {
		// Thread unsafe collection, and declared as final because only final
		// can be used in inner class block;
		final PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		new Thread() {
			@Override
			public void run() {
				System.out.println("Remove element: " + pq.remove()
						+ " from pq.");
			}
		}.start();
		;
		new Thread() {
			@Override
			public void run() {
				System.out.println("Successfully added element:"
						+ pq.add(new Integer(10)));
			}
		}.start();
		;
	}
	// Safe operation on collection
	static void safeCollection() {
		// Thread unsafe collection, and declared as final because only final
		// can be used in inner class block;
		final PriorityBlockingQueue<Integer> pq = new PriorityBlockingQueue<Integer>();

		new Thread() {
			@Override
			public void run(){
				try {
					System.out.println("Remove element: " + pq.take() // remove() still caused an exception
							+ " from pq.");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		;
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Successfully added element:"
						+ pq.add(new Integer(10)));
			}
		}.start();
		;
	}
	public static void main(String[] args) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main thread ");
		safeCollection();
	}
}
