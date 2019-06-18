class Solution(object):
    def canCross(self, stones):
        """
        :type stones: List[int]
        :rtype: bool
        """
        q = collections.deque()
        v = collections.defaultdict(lambda: collections.defaultdict(bool))
        stoneSet = set(stones)
        q.append((0, 0))
        v[0][0] = True
        while q:
            x, y = q.popleft()
            if x == stones[-1]:
                return True
            for z in (y-1,y,y+1):
                if z>0 and not v[x+z][z] and x+z in stoneSet:
                    v[x+z][z] = True
                    q.append((x+z,z))
        
        return False
        
