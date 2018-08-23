class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        first=[]
        i=0
        while(i<len(nums)-2):
            if(nums[i]!=nums[i-1] or i==0):
                target=0-nums[i]
                left=i+1
                right=len(nums)-1
                while(left!=right):
                    if(nums[left]+nums[right]==target):
                        first.append([nums[i],nums[left],nums[right]])
                        while(left<right):
                            left+=1
                            if(nums[left]!=nums[left-1]):
                                break
                        while(right>left):
                            right-=1
                            if(nums[right]!=nums[right+1]):
                                break
                    elif(nums[left]+nums[right]>target):
                        right-=1
                    elif(nums[left]+nums[right]<target):
                        left+=1
            i+=1
        return first

        
