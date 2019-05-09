class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        envelopes.sort(key = lambda x : (x[0], -x[1]))
        
        #print(envelopes)
        
        lst = []
        
        for start, end in envelopes:
            lo, hi = 0, len(lst)
            
            while lo < hi:
                mid = (lo + hi) // 2
                
                if end > lst[mid]:
                    lo = mid + 1
                else:
                    hi = mid
                    
            if lo == len(lst):
                lst.append(end)
            else:
                lst[lo] = end
                
        return len(lst)
        
