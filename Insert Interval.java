/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//   Thought1
/*   
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null) return result;
        intervals.add(newInterval);
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comparator);
        for (Interval interval : intervals) {
            int last = result.size();
            if (last == 0 || result.get(last - 1).end < interval.start) {
                Interval interval1 = new Interval(interval.start, interval.end);
                result.add(interval1);
            } else {
                result.get(last - 1).end = Math.max(interval.end, result.get(last - 1).end);
            }
        }
        return result;
    }
}
*/

//   Thought2
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
            
        for(Interval each: intervals){
            if(each.end < newInterval.start){
                res.add(each);
            }else if(each.start > newInterval.end){
                res.add(newInterval);
                newInterval = each;        
            }else if(each.end >= newInterval.start || each.start <= newInterval.end){
                int nstart = Math.min(each.start, newInterval.start);
                int nend = Math.max(newInterval.end, each.end);
                newInterval = new Interval(nstart, nend);
            }
        }
 
        res.add(newInterval); 
 
        return res;
    }
}
