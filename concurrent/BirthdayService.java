import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用BlockingQueue实现一个生产-消费实例
 *
 */
public class BirthdayService {

	final int workerNumber;
	final Worker[] workers;
	final ExecutorService threadPool;
	static volatile boolean running=true;
	
	public BirthdayService(int workerNumber,int capacity){
		this.workerNumber=workerNumber;
		workers=new Worker[workerNumber];
		for(int i=0;i<workerNumber;i++){
			workers[i]=new Worker(capacity);
		}
		
		boolean b=running;
		threadPool=Executors.newFixedThreadPool(workerNumber);
		for(Worker w:workers){
			threadPool.submit(w);
		}
	}
	
	Worker getWorker(int id){
		return workers[id%workerNumber];
	}
	
	public void accept(int id){
		getWorker(id).put(id);
	}
	
	protected void consume(int id) {
		
	}
	
	class Worker implements Runnable{

		final BlockingQueue<Integer> queue;
		
		public Worker(int capacity){
			queue=new LinkedBlockingQueue<>(capacity);
		}
		
		@Override
		public void run() {
			try {
				consume(queue.take());
			} catch (InterruptedException e) {
				return;
			}
		}
		
		void put(int id){
			try {
				queue.put(id);
			} catch (InterruptedException e) {
				return;
			}
		}
		
	}
	
}
