class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int windowSize = 0;
        int maxF = 0;

        int l = 0; 
        int r = 0;
        int maxWindow = 0;
        while(r < s.length()){
            Character c = s.charAt(r);
            if(freqMap.containsKey(c)){
                freqMap.put(c, freqMap.get(c)+1);
            } else {
                freqMap.put(c,1);
            }
            ++r;
            ++windowSize;
            maxF = Math.max(freqMap.get(c), maxF);
            while(windowSize - maxF > k){
                c = s.charAt(l);
                freqMap.put(c, freqMap.get(c)-1);
                ++l;
                --windowSize;
            }
            maxWindow = Math.max(maxWindow, windowSize);
        }
        return maxWindow;  
    }
}
