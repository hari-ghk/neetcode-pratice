class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        memo = {}
        def findMinCost(cost, current_stairs, n):
            if current_stairs >= n:
                return 0

            if current_stairs in memo:
                return memo[current_stairs]
            
            total_cost = cost[current_stairs]
            total_cost += min(findMinCost(cost, current_stairs+1, n), findMinCost(cost, current_stairs+2, n))
            memo[current_stairs] = total_cost
            return total_cost
        return min(findMinCost(cost, 0, len(cost)), findMinCost(cost, 1, len(cost)))        