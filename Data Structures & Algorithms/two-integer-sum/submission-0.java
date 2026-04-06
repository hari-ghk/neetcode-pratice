class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexArray = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            indexArray.put(nums[i], i);
        }

        int diff = 0;
        for(int i = 0; i < nums.length; ++i){

            diff = target - nums[i];
            if(indexArray.containsKey(diff) && indexArray.get(diff) != i)
                return new int[] {i, indexArray.get(diff)};         
        }
        return new int[] {};
    }
}
