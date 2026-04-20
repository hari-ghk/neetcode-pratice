class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0] * len(temperatures)
        stack = []
        stack.append(0)
        curr_idx = 0
        for i in range(1,len(temperatures)):        
            while stack and (temperatures[i] > temperatures[stack[-1]]):
                curr_idx = stack.pop()
                res[curr_idx] = i - curr_idx
            stack.append(i)
        return res  