class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // expand until  r-l == 3, increase l, 
        // track max so far and index 
        int r = 0;
        int l = 0;
        int[] max = new int[nums.length-k+1]; 
        int maxSoFar = Integer.MIN_VALUE;
        int idx = 0;
        int ctr = 0;
        while(r < nums.length){
            if(maxSoFar < nums[r]){
                maxSoFar = nums[r];
                idx = r;
            }
           // System.out.println("idx " + idx + " l " + l);
            if((r-l+1) == k){
                max[ctr] = maxSoFar;
                ++ctr;
                ++l;

                //System.out.println("ctr " + ctr + " l " + l);
                if(idx < l){
                    maxSoFar = Integer.MIN_VALUE;
                    for(int i = l; i <=r; ++i){
                        if(maxSoFar < nums[i]){
                            maxSoFar = nums[i];
                            idx = i;
                        }
                    }
                }    
            }
            ++r;
        }
        return max;
    }
}
