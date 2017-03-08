package lib;

import java.util.Scanner;

/**
 * Created by earthgee on 2017/2/7.
 */
public class ShellSort extends BaseSort{

    @Override
    public void sort(Comparable[] a) {
        int count=a.length;
        int h=1;
        while(h<count/3) h=3*h+1;
        while(h>=1){
            for(int i=h;i<count;i++){
                for(int j=i;j>=h&&ShellSort.less(a[j],a[j-h]);j-=h){
                    ShellSort.exch(a,j,j-h);
                }
            }
            h=h/3;
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
