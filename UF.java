package lib;

/**
 * Created by earthgee on 17/4/4.
 */
public class UF {

    private int[] id;
    private int[] sz;
    private int count;

    public UF(int N){
        count=N;
        id=new int[N];
        sz=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            sz[i]=1;
        }
    }

    void union(int p,int q){
        int i=find(p);
        int j=find(q);
        if(i==j) return;
        if(sz[i]<sz[j]){
            id[i]=j;sz[j]+=sz[i];
        }else{
            id[j]=i;sz[i]+=sz[j];
        }
        count--;
    }

    int find(int p){
        while (p!=id[p]) p=id[p];
        return p;
    }

    boolean connected(int p,int q){
        return find(p)==find(q);
    }

    int count(){
        return count;
    }

}
