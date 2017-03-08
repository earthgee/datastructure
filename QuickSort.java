package lib;

import java.util.Scanner;

/**
 * Created by earthgee on 2017/2/12.
 */
public class QuickSort extends BaseSort{

    @Override
    public void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }

    private void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private int partition(Comparable[] a,int lo,int hi){
        int i=lo,j=hi+1;
        Comparable v=a[lo];
        while(true){
            while(QuickSort.less(a[++i],v)) if(i==hi) break;
            while(QuickSort.less(v,a[--j])) if(j==lo) break;
            if(i>=j) break;
            QuickSort.exch(a,i,j);
        }
        QuickSort.exch(a, lo, j);
        return j;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input=in.nextLine();
        String[] a=input.split(" ");
        BaseSort sort=new QuickSort();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
    }

}
