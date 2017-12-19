import java.util.concurrent.CountDownLatch;

public class PerformanceTestTool {

	public long timecost(final int times,final Runnable task) throws InterruptedException{
		if(times<=0) throw new IllegalArgumentException();
		final CountDownLatch startLatch=new CountDownLatch(1);
		final CountDownLatch overLatch=new CountDownLatch(times);
		
		for(int i=0;i<times;i++){
			new Thread(new Runnable() {
				public void run() {
					try {
						startLatch.await();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}finally {
						overLatch.countDown();
					}
				}
			}).start();
		}
		
		long start=System.nanoTime();
		startLatch.countDown();
		overLatch.await();
		return System.nanoTime()-start;
	}
	
	public static void main(String[] args) throws InterruptedException {
		PerformanceTestTool tool=new PerformanceTestTool();
		System.out.println(tool.timecost(20, new Runnable() {
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}));
	}
	
}
