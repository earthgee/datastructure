import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 使用Condition实现的阻塞队列模型
 * 使用Condition可以实现和Object.wait,notify,notifyAll相同的语义，且更灵活
 * 每一个Lock可以有任意数量的Condition对象,而与synchnorized对应的模型限制在Object上
 * 
 * await与wait一样会释放锁，signal/signalAll会唤起await的，并允许一个await点的线程重新拿到锁
 */
public class ProductQueue<T> {

	private final T[] items;
	private final Lock lock=new ReentrantLock();
	private Condition notFull=lock.newCondition();
	private Condition notEmpty=lock.newCondition();
	
	private int head,tail,count;
	
	public ProductQueue(int maxSize){
		items=(T[]) new Object[maxSize];
	}
	
	public ProductQueue(){
		this(10);
	}
	
	public int getCapacity(){
		return items.length;
	}
	
	public int size(){
		lock.lock();
		try{
			return count;
		}finally{
			lock.unlock();
		}
	}
	
	public void put(T t) throws InterruptedException{
		lock.lock();
		try{
			while(count==getCapacity()){
				notFull.await();
			}
			items[tail]=t;
			if(++tail==getCapacity()){
				tail=0;
			}
			++count;
			notEmpty.signalAll();
		}finally{
			lock.unlock();
		}
	}
	
	public T take() throws InterruptedException{
		lock.lock();
		try{
			while(count==0){
				notEmpty.await();
			}
			T ret=items[head];
			items[head]=null;
			if(++head==getCapacity()){
				head=0;
			}
			--count;
			notFull.signalAll();
			return ret;
		}finally{
			lock.unlock();
		}
	}
	
}







