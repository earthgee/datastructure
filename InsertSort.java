package lib;

import java.util.Scanner;

/**
 * Created by earthgee on 2017/2/6.
 */
public class InsertSort extends BaseSort{

    @Override
    public void sort(Comparable[] a) {
        int count=a.length;
        for(int i=1;i<count;i++){
            for(int j=i;j>0&&InsertSort.less(a[j],a[j-1]);j--){
                InsertSort.exch(a,j,j-1);
            }
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
