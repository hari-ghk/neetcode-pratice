class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        
        if(s1.trim().isEmpty())
            return true;

        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < s1.length(); ++i){
            freqMap.put(s1.charAt(i), freqMap.getOrDefault(s1.charAt(i), 0)+1);
        }
        //freqMap.forEach((key,value) -> System.out.println("FreqMap key" + key + " value " + value));
        int l = 0;
        int r = 0;
        int len = s1.length();
        Map<Character, Integer> currFreq = new HashMap<>();
        while(r < s2.length()){
            System.out.println("curr char "+ s2.charAt(r));
            if(currFreq.containsKey(s2.charAt(r)))
                currFreq.put(s2.charAt(r), currFreq.get(s2.charAt(r))+1);
            else 
                currFreq.put(s2.charAt(r), 1);
            ++r;
            while((r-l) > len){
                currFreq.put(s2.charAt(l), currFreq.get(s2.charAt(l))-1);
                if(currFreq.get(s2.charAt(l)) == 0)
                    currFreq.remove(s2.charAt(l));
                ++l;
            }
            System.out.println("All Values");
            currFreq.forEach((key,value) -> System.out.println(" CurrFreq key " + key + " value " + value));
            if(currFreq.equals(freqMap))
                return true;
        }
        return false;
    }
}
