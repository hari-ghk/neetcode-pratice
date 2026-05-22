class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i = 0; i < t.length(); ++i){
            Character c = t.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);  
        }

        String subStr = "";
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int formed = 0;  
        int required = charCount.size();
        Map<Character, Integer> sCharCount = new HashMap<>();
        
        while(r < s.length()){
            Character c = s.charAt(r);
            sCharCount.put(c, sCharCount.getOrDefault(c, 0) + 1);
            
            if(charCount.containsKey(c) && 
               sCharCount.get(c).equals(charCount.get(c)))
                formed++;

            while(formed == required){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    subStr = s.substring(l, r + 1);
                }

                Character leftC = s.charAt(l);
                sCharCount.put(leftC, sCharCount.get(leftC) - 1);
                
                if(charCount.containsKey(leftC) && 
                   sCharCount.get(leftC) < charCount.get(leftC))
                    formed--;
                l++;
            }
            r++;
        }
        return subStr;
    }
}