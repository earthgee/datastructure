import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

	public static void main(String[] args) throws Exception{
		ScheduledExecutorService executorService=
				Executors.newScheduledThreadPool(3);
		executorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"->"+System.currentTimeMillis());
				try{
					Thread.sleep(2000);
				}catch(Exception e){
					
				}
			}
		}, 1, 1, TimeUnit.SECONDS);
		executorService.scheduleWithFixedDelay(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"->"+System.currentTimeMillis());
				try{
					Thread.sleep(2000);
				}catch(Exception e){
					
				}
			}
		}, 1, 1, TimeUnit.SECONDS);
		Thread.sleep(5000L);
		executorService.shutdown();
	}
	
}







