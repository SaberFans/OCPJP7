class ThreadMultiStart extends Thread{
	public ThreadMultiStart() {
		Delimiter.printDelimiter(this.getClass());
	}
	@Override
	public void run() {
		try {
			for(int i=0;i<3;i++){
				System.out.println(i+1);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted..");
		}
	}
}

public class ThreadCh{
	public static void main(String[] args) throws InterruptedException {
		ThreadMultiStart tms = new ThreadMultiStart();
		tms.start();
		// Can't start tms when it's running or even after dead
		tms.start();
	}
}