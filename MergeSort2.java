package lib;

import java.util.Scanner;

/**
 * Created by earthgee on 2017/2/9.
 * 自底向上
 */
public class MergeSort2 extends BaseSort{

    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux=new Comparable[a.length];
        int N=a.length;
        for(int sz=1;sz<N;sz=sz+sz){
            for(int lo=0;lo<N-sz;lo+=sz+sz){
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
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
