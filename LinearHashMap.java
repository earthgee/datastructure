package lib;

/**
 * Created by earthgee on 2017/3/5.
 * 基于线性探测的散列表
 */
public class LinearHashMap<Key,Value> {

    private int N;
    private int M=16;
    private Key[] keys;
    private Value[] values;

    public LinearHashMap(){
        keys= (Key[]) new Object[M];
        values= (Value[]) new Object[M];
    }

    public LinearHashMap(int cap){
        keys= (Key[]) new Object[cap];
        values= (Value[]) new Object[cap];
    }

    private int hash(Key key){
        return (key.hashCode()&0x7fffffff)%M;
    }

    public void put(Key key,Value value){
        if(N>=M/2){
            resize(2*M);
        }

        int i;
        for(i=hash(key);keys[i]!=null;i=(i+1)%M){
            if(keys[i].equals(key)){
                values[i]=value;
            }
        }

        keys[i]=key;
        values[i]=value;
        N++;
    }

    public Value get(Key key){
        for(int i=hash(key);keys[i]!=null;i=(i+1)%M){
            if(keys[i].equals(key)){
                return values[i];
            }
        }
        return null;
    }

    public void delete(Key key){
        if(get(key)==null) return;
        int i=hash(key);
        while(!key.equals(keys[i])){
            i=(i+1)%M;
        }
        keys[i]=null;
        values[i]=null;
        i=(i+1)%M;
        while(keys[i]!=null){
            Key keyToRedo=keys[i];
            Value valToRedo=values[i];
            keys[i]=null;
            values[i]=null;
            N--;
            put(keyToRedo,valToRedo);
            i=(i+1)%M;
        }
        N--;
        if(N>0&&N==M/8) resize(M/2);
    }

    
    private void resize(int cap){
        LinearHashMap<Key,Value> t;
        t=new LinearHashMap<>(cap);
        for(int i=0;i<M;i++){
            if(keys[i]!=null){
                t.put(keys[i],values[i]);
            }
        }
        keys=t.keys;
        values=t.values;
        M=t.M;
    }

}









