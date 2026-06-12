class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
    
        if(hand.length % groupSize != 0)
            return false;

        int minB = Integer.MAX_VALUE;
        int maxB = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for(int i = 0; i < hand.length; ++i){
            minB = Math.min(minB, hand[i]);
            maxB = Math.max(maxB, hand[i]);
            countMap.put(hand[i], countMap.getOrDefault(hand[i], 0) + 1);
        }

        int currFormed = 0;
        while(countMap.size() != 0){
            int startPoint = countMap.firstKey(); 
            int term = startPoint + groupSize - 1;
            //System.out.println(startPoint + " " + term);
            while(startPoint <= term){
                if(!countMap.containsKey(startPoint)){
                    return false;
                }
                else {
                    countMap.put(startPoint, countMap.get(startPoint)-1);
                    if(countMap.get(startPoint) == 0)
                        countMap.remove(startPoint);
                }
                ++startPoint;
            }
        }
        return true;
    }
}
