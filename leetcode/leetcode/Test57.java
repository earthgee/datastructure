import java.util.List;

//步骤
/*
 * - 对区间集中每个区间进行遍历

　　- 如果新区间的末尾小于当前区间的开头，则跳出循环

　　- 如果新区间的开头大于当前区间的末尾，不作处理

　　- 如果新区间和当前区间有重叠，则更新新区间的开头为两者最小值，新区间的末尾为两者最大值，重叠数加一

　　- 指针移向下一个区间

- 如果重叠数大于0，则删除掉所有的重叠区间

- 插入新区间到对应的位置
 */
public class Test57 {
	
	public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int length=intervals.size();
        int delete=0;
        int index;
        for(index=0;index<length;index++){
        	Interval current=intervals.get(index);
			if(newInterval.end<current.start) break;
			else if(newInterval.start>current.end) continue;
			else {
				newInterval.start=Math.min(current.start, newInterval.start);
				newInterval.end=Math.max(current.end, newInterval.end);
				delete++;
			}
		}
        
        intervals.add(index, newInterval);
        for(index=index-1;delete>0;delete--,index--){
        	intervals.remove(index);
        }
        
        return intervals;
    }
	
	
	
}
