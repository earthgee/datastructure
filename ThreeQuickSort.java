package lib;

import java.util.Scanner;

/**
 * Created by earthgee on 2017/2/12.
 */
public class ThreeQuickSort extends BaseSort{

    @Override
    public void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }

    private void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int lt=lo,i=lo+1,gt=hi;
        Comparable v=a[lo];
        while(i<=gt){
            int cmp=a[i].compareTo(v);
            if(cmp<0) QuickSort.exch(a,lt++,i++);
            else if(cmp>0) QuickSort.exch(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input=in.nextLine();
        String[] a=input.split(" ");
        BaseSort sort=new ThreeQuickSort();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
    }

}
