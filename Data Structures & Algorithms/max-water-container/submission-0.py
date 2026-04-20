class Solution:
    def maxArea(self, heights: List[int]) -> int:
        maxArea = 0
        s = 0
        l = len(heights)-1
        currArea = 0 
        while s < l: 
            currArea = min(heights[s], heights[l]) * (l-s)
            maxArea = max(currArea, maxArea)
            if heights[s] < heights[l]:
                s += 1
            else:
                l -= 1
        return maxArea
        