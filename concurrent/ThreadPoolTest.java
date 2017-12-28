import java.lang.reflect.Field;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * void execute(Runnable task)
 * Future<?> submit(Runnable task)
 * <T> Future<T> submit(Callable<T> task)
 *
 */
public class ThreadPoolTest {
	
	static void log(String msg){
		System.out.println(System.currentTimeMillis()+"->"+msg);
	}
	
	static int getThreadPoolRunState(ThreadPoolExecutor pool) throws Exception{
		Field field=ThreadPoolExecutor.class.getDeclaredField("runState");
		field.setAccessible(true);
		int v=field.getInt(pool);
		return v;
	}

	public static void main(String[] args) throws Exception{
		ThreadPoolExecutor pool=new 
				ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(1));
		pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
		for(int i=0;i<10;i++){
			final int index=i;
			pool.submit(new Runnable() {
				@Override
				public void run() {
					log("run task:"+index+"->"+Thread.currentThread().getName());
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
						Thread.currentThread().interrupt();
					}
					log("run over:"+index+"->"+Thread.currentThread().getName());
				}
			});
		}
		log("before sleep");
		Thread.sleep(4000);
		log("before shutdown");
		pool.shutdown();
		log("after shutdown(),pool="+pool.isTerminated());
		pool.awaitTermination(1000, TimeUnit.SECONDS);
		log("now,pool is="+pool.isTerminated());
	}
	
}












