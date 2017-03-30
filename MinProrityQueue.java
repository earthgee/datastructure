package lib;

/**
 * Created by earthgee on 2017/3/31.
 */
public class MinProrityQueue<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N=0;

    public MinProrityQueue(int max){
        pq= (Key[]) new Comparable[max+1];
    }

    void insert(Key k){
        pq[++N]=k;
        swim(N);
    }

    Key delMin(){
        Key k=pq[1];
        exch(1,N--);
        pq[N+1]=null;
        sink(1);
        return k;
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

    public void swim(int k){
        while(k>1&&less(k,k/2)){
            exch(k/2,k);
            k=k/2;
        }
    }

    public void sink(int k){
        while(2*k<=N){
            int j=2*k;
            if(j<N&&less(j+1,j)) j++;
            if(less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }

}
