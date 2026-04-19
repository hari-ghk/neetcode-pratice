class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        s = 0
        l = len(numbers) - 1
        sum = 0

        while s < l:
            sum = numbers[s] + numbers[l]
            print(sum)
            if sum == target:
                return [s+1,l+1]
            elif sum > target:
                l -= 1    
            else:
                s += 1
        return [-1,-1]   