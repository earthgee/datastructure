package lib;

import java.util.Comparator;

/**
 * Created by earthgee on 17/4/4.
 */
public class IndexMinPQ<Key extends Comparable<Key>> {

    private int N;
    private int[] pq;
    private int[] qp;
    private Key[] keys;

    public IndexMinPQ(int maxN){
        keys= (Key[]) new Comparable[maxN+1];
        pq= new int[maxN+1];
        qp=new int[maxN+1];
        for(int i=0;i<=maxN;i++){
            qp[i]=-1;
        }
    }

    public boolean isEmpty(){
        return N==0;
    }

    public boolean contains(int k){
        return qp[k]!=-1;
    }

    public void insert(int k,Key key){
        N++;
        qp[k]=N;
        pq[N]=k;
        keys[k]=key;
        swim(N);
    }

    public int delMin(){
        int indexOfMin=pq[1];
        exch(1,N--);
        sink(1);
        keys[pq[N+1]]=null;
        qp[pq[N+1]]=-1;
        return indexOfMin;
    }

    public void change(int k,Key key){
        keys[k]=key;
        swim(qp[k]);
        sink(qp[k]);
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

    public boolean less(int i,int j){
        return keys[pq[i]].compareTo(keys[pq[j]])<0;
    }

    public void exch(int i,int j){
        Key t=keys[pq[i]];
        keys[pq[i]]=keys[pq[j]];
        keys[pq[j]]=t;
    }

}









