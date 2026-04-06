class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> valueSet = new HashSet<Integer>();
        for(int i = 0; i < nums.length; ++i){
            if(valueSet.contains(nums[i]))
                return true; 
            valueSet.add(nums[i]);     
        }
    return false;
    }
}