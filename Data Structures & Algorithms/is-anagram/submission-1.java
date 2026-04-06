class Solution {
    public boolean isAnagram(String s, String t) {

        //if they are two different lenghts, return false
        
        // go through all the characters in the array, get their int
        // and xor, find out if the xor is one then return true
        boolean isAnagram;
        if(s.length() != t.length())
            return false; 
        else if(s.length() == 0 && t.length() == 0)
            return true;
        else {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            s = new String(charArray);

            charArray = t.toCharArray();
            Arrays.sort(charArray);

            t = new String(charArray);

            if(s.equals(t))
                return true;
        }  
        return false;        
    }
}
