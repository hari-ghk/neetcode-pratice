class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [-1] * (n+1)
        def countClimbingStairs(stairs, c1, c2):
            if stairs == 0:
                return 1
            c1_count = 0
            c2_count = 0
            if stairs - c1 >= 0 and dp[stairs-c1] != -1:
                c1_count = dp[stairs - c1]
            elif stairs - c1 >= 0:
                c1_count = countClimbingStairs(stairs-c1, c1, c2)
                dp[stairs - c1] = c1_count

            if stairs - c2 >= 0 and dp[stairs-c2] != -1:
                c2_count = dp[stairs - c2]
            elif stairs - c2 >= 0:
                c2_count = countClimbingStairs(stairs-c2, c1, c2)
                dp[stairs - c2] = c2_count
            return c1_count + c2_count

        return countClimbingStairs(n, 1, 2)