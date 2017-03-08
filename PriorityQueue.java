package lib;

/**
 * Created by earthgee on 2017/2/12.
 * 最大优先队列+堆排序
 */
public class PriorityQueue<Key extends Comparable<Key>> extends BaseSort{

    private Key[] pq;
    private int N=0;

//    public PriorityQueue(){
//
//    }

    public PriorityQueue(int max){
        pq= (Key[]) new Comparable[max+1];
    }

//    public PriorityQueue(Key[] a){
//
//    }

    void insert(Key v){
        pq[++N]=v;
        swim(N);
    }

    Key delMax(){
        Key max=pq[1];
        exch(1,N--);
        pq[N+1]=null;
        sink(1);
        return max;
    }

    boolean isEmpty(){
        return N==0;
    }

    int size(){
        return N;
    }

    public boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    public void exch(int i,int j){
        Key t=pq[i];
        pq[i]=pq[j];
        pq[j]=t;
    }

    private void swim(int k){
        while(k>1&&less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }

    private void sink(int k){
        while(2*k<=N){
            int j=2*k;
            if(j<N&&less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }

    private void sink(Comparable[] a,int k,int size){
        while(2*k<=size){
            int j=2*k;
            if(j<size&&a[j].compareTo(a[j+1])<0) j++;
            if(a[k].compareTo(a[j])>0) break;
            Comparable tmp=a[k];
            a[k]=a[j];
            a[j]=tmp;
        }
    }

    @Override
    public void sort(Comparable[] a) {
        int N=a.length;
        for(int k=N/2;k>=1;k--){
            sink(a,k,N);
        }
        while(N>1){
            PriorityQueue.exch(a,1,N--);
            sink(a,1,N);
        }
    }
}
