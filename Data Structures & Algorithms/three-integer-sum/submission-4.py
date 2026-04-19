class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        s = 0
        l = 0
        sum = 0
        res = []
        i = 0
        while i < (len(nums)-2):
            s = i + 1
            l = len(nums)-1

            if i > 0 and nums[i] == nums[i-1]:
                i += 1     
                continue
            
            while s < l:
                sum = nums[i] + nums[s] + nums[l]
                if sum == 0:
                    res.append([nums[i], nums[s], nums[l]])
                    s += 1
                    l -= 1
                    while s < l and nums[s] == nums[s-1]: 
                        s += 1
                    while s < l and nums[l] == nums[l+1]:
                        l -= 1
                elif sum > 0:
                    l -= 1
                else:
                    s += 1  
            i += 1        
        return res            