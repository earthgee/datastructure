package lib;

/**
 * Created by earthgee on 17/4/4.
 */
public class DirectedEdge {

    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v,int w,double weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }

    double weight(){
        return weight;
    }

    int from(){
        return v;
    }

    int to(){
        return w;
    }



}
