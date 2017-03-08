package lib;

import java.util.Scanner;

/**
 * Created by earthgee on 2017/2/5.
 */
public class ChooseSort extends BaseSort{

    @Override
    public void sort(Comparable[] a) {
        int count=a.length;
        for(int i=0;i<count-1;i++){
            int result=i;
            for(int j=i+1;j<count;j++){
                if(ChooseSort.less(a[j],a[result])){
                    result=j;
                }
            }
            ChooseSort.exch(a,i,result);
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
