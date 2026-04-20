class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        stack = []
        paired = list(zip(position, speed)) 
        paired.sort(reverse=True)
        for pos,speed in paired:
            time_taken = (target-pos)/speed
            if stack and time_taken <= stack[-1]:
                continue
            stack.append(time_taken)
        return len(stack)