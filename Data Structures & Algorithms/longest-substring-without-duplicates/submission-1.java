class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;

        Set<Character> currWindow = new HashSet<>();
        int l = 0;
        int r = 0;
        int maxL = 0;
        while(r < s.length()){
            if(!currWindow.contains(s.charAt(r))){
              currWindow.add(s.charAt(r));
              r += 1;
              maxL = Math.max(maxL, r-l);
            } else {
                while(currWindow.contains(s.charAt(r))){
                    currWindow.remove(s.charAt(l));
                    l += 1;
                }
            }
        }
        return maxL;
    }
}
