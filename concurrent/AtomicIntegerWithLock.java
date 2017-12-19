
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
lock:获取锁
如果该锁没有被另一个线程保持，则获取该锁并立即返回，将锁的保持计数设置为1
如果当前线程已经保持该锁，则将保持计数加1，并且该方法立即返回
如果该锁被另一个线程保持，则在获得锁之前，该线程将一直处于休眠状态，此时锁保持计数被设置为1

lock会委托Sync.lock。Sync有两个实现：
FairSync：公平锁
NonFairSync：非公平锁，在性能上占优，但可能导致饥饿

lock实际上调用了aps的acquire方法
acquire的方法原型：public final void acquire(int arg)
acquire方法的步骤：
1.tryAcquire(arg)成功，lock过程结束，失败进行2
2.创建一个独占节点，并且此节点加入CHL队列末尾，进行3
3.自旋尝试获取锁，失败根据前一个节点决定是否挂起（park），直到成功获取锁
4.如果当前线程已经被中断过，那么就中断当前线程

tryAcquire失败会入队列，可以选择是独占模式还是共享模式
*/
public class AtomicIntegerWithLock {

	private int value;
	private Lock lock=new ReentrantLock();
	
	public AtomicIntegerWithLock(){
		super();
	}
	
	public AtomicIntegerWithLock(int value){
		this.value=value;
	}
	
	public final int get(){
		lock.lock();
		try{
			return value;
		}finally{
			lock.unlock();
		}
	}
	
	public final void set(int newValue){
		lock.lock();
		try{
			value=newValue;
		}finally{
			lock.unlock();
		}
	}
	
	public final int getAndSet(int newValue){
		lock.lock();
		try{
			int ret=value;
			value=newValue;
			return ret;
		}finally{
			lock.unlock();
		}
	}
	
	public final boolean compareAndSet(int expect,int update){
		lock.lock();
		try{
			if(value==expect){
				value=update;
				return true;
			}
			return false;
		}finally{
			lock.unlock();
		}
	}
	
	public final int getAndIncrement(){
		lock.lock();
		try{
			return value++;
		}finally{
			lock.unlock();
		}
	}
	
	public final int getAndDecrement(){
		lock.lock();
		try{
			return value--;
		}finally{
			lock.unlock();
		}
	}
	
	public final int incrementAndGet(){
		lock.lock();
		try{
			return ++value;
		}finally{
			lock.unlock();
		}
	}
	
	public final int decrementAndGet(){
		lock.lock();
		try{
			return --value;
		}finally{
			lock.unlock();
		}
	}
	
	public String toString(){
		return Integer.toString(get());
	}
	
}







