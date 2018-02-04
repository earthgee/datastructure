import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//先排序 再将有交叉的合并
//todo 需要后面review一种图搜的方法 在leetcode解答上
public class Test56 {

	public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()==0) return intervals;
		sort(intervals,0,intervals.size()-1);
        List<Interval> res=new ArrayList<>();
        Interval interval=new Interval(intervals.get(0).start, intervals.get(0).end);
        for(int index=1;index<intervals.size();index++){
        	Interval tmp=intervals.get(index);
        	if(tmp.start<=interval.end){
        		interval.end=Math.max(interval.end, tmp.end);
        	}else{
        		Interval ans=new Interval(interval.start, interval.end);
        		res.add(ans);
        		interval=new Interval(intervals.get(index).start, intervals.get(index).end);
        	}
        }
        res.add(interval);
        
        return res;
    }
	
	private void sort(List<Interval> intervals,int lo,int hi){
		if(lo>=hi) return;
		int j=partition(intervals,lo,hi);
		sort(intervals, lo, j-1);
		sort(intervals, j+1, hi);
	}
	
	private int partition(List<Interval> intervals,int lo,int hi){
		int i=lo,j=hi+1;
		int cmp=intervals.get(lo).start;
		while(true){
			while(intervals.get(++i).start<cmp) if(i==hi) break;
			while(intervals.get(--j).start>cmp);
			if(i>=j) break;
			Collections.swap(intervals, i, j);
		}
		Collections.swap(intervals, lo, j);
		return j;
	}
	
}
