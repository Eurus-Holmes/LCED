/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return -1;
                if (o1.start > o2.start) return 1;
                return 0;
            }
        });
        List<Interval> ans = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                ans.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }
}
