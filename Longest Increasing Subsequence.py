class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        size=len(nums)
        ans=[]
        
        for x in range(size):
            low=0
            high=len(ans)-1
            
            while low<=high:
                
                mid=(low+high)/2
                
                if ans[mid]<nums[x]:        #目的就是把下一个大的元素放在相应的位置：如果比最后一个大，就append到最后
                    low=mid+1               #如果不是比最后一个大，就找到那个位置low，把low替换成这个值
                else:
                    high=mid-1              #如果ans[mid]>nums[x], 则用 high<low 去控制，然后把low上的值代替
                
                
            if low>=len(ans):                 #初始时ans[0]=nums[0]，逐个向后比较，遇到大的，则加在ans后面
                ans.append(nums[x])
            else:                               #遇到小的，则把它放在最小，因为是要升序的子序列
                ans[low]=nums[x]
            
            
        return len(ans)

        
