class Solution {
    public boolean canJump(int[] nums) {
      boolean dp[] = new boolean[nums.length];
      Arrays.fill(dp,false);
      boolean visited[] = new boolean[nums.length];
      Arrays.fill(visited,false);
      return doesPathExist(nums, 0, dp, visited);
    }

    private boolean doesPathExist(int[] nums, int currPos, boolean dp[], boolean visited[]){
        if(currPos > nums.length)
            return false;

        if(currPos == nums.length-1)
            return true;
        
        if(visited[currPos])
            return dp[currPos];

        int maxJump = nums[currPos]; 
        int i = 1; 
        boolean isPossible = false;
        while(i <= maxJump){
            isPossible = doesPathExist(nums, currPos+i, dp, visited);
            visited[currPos] = true;
            dp[currPos] = isPossible;
            if(isPossible)
                return true;
            ++i;
        } 
        return false;
    }
}
