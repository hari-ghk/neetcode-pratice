class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; ++i){
            max = Math.max(piles[i], max);
        }

        int l = 1;
        int r = max;
        int totalTime = 0;
        int mid = 0;
        int res = 0;
        while(l <= r){
            mid = l + (r-l)/2;
            totalTime = 0;
            for(int i = 0; i < piles.length; ++i){
                totalTime += Math.ceil(piles[i]/(double)mid);
            }
            if(totalTime <= h) 
                r = mid - 1;
            else 
                l = mid + 1;
        }
        return l;
    }
}
