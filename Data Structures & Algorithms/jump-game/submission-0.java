class Solution {
    public boolean canJump(int[] nums) {
      return doesPathExist(nums, 0);
    }

    private boolean doesPathExist(int[] nums, int currPos){
        if(currPos > nums.length)
            return false;

        if(currPos == nums.length-1)
            return true;
        
        int maxJump = nums[currPos]; 
        int i = 1; 
        boolean isPossible = false;
        while(i <= maxJump){
            isPossible = doesPathExist(nums, currPos+i);
            if(isPossible)
                return true;
            ++i;
        } 
        return false;
    }
}
