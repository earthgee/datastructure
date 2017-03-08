package lib;

import java.util.Scanner;

/**
 * Created by earthgee on 2017/2/5.
 */
public abstract class BaseSort {

    public abstract void sort(Comparable[] a);

    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    public static void exch(Comparable[] array,int i,int j){
        Comparable t=array[i];
        array[i]=array[j];
        array[j]=t;
    }

    public void show(Comparable[] array){
        for(Comparable a:array){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input=in.nextLine();
        String[] a=input.split(" ");
        BaseSort sort=null;
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
    }

}
