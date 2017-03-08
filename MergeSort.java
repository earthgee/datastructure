package lib;

import java.util.Scanner;

/**
 * Created by earthgee on 2017/2/7.
 * 自顶向下
 */
public class MergeSort extends BaseSort{

    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux=new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private void sort(Comparable[] a,int lo,int hi){
        if(lo>=hi) return;
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a, lo, mid, hi);
    }

    private void merge(Comparable[] a,int lo,int mid,int hi){
        int i=lo,j=mid+1;

        for(int k=lo;k<=hi;k++){
            aux[k]=a[k];
        }

        for(int k=lo;k<=hi;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(MergeSort.less(aux[i],aux[j])) a[k]=aux[i++];
            else a[k]=aux[j++];
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input=in.nextLine();
        String[] a=input.split(" ");
        BaseSort sort=new ChooseSort();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
    }

}
