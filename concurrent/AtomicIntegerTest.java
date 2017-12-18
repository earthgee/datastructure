import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
	
	static AtomicInteger value=new AtomicInteger(10);
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] threads=new Thread[10];
		for(int i=0;i<10;i++){
			threads[i]=new Thread(){
				public void run() {
					value.incrementAndGet();
				}
			};
		}
		
		for(Thread t:threads){
			t.start();
		}
		
		for(Thread t:threads){
			t.join();
		}
		
		System.out.println(value.get());
	}
	
}
