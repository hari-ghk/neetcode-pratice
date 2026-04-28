class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList<>();

        
        Map<List<Integer>, List<String>> anagrams = new HashMap<>();
        for(int i = 0; i < strs.length; ++i){
            
            List<Integer> count = new ArrayList<>(Collections.nCopies(26, 0));
            if(strs[0].trim() != "")
            {
                for(int j = 0; j < strs[i].length(); ++j){
                    int index = strs[i].charAt(j) - 'a';
                    count.set(index, count.get(index) + 1);
                }
            }    
            anagrams.computeIfAbsent(count, k -> new ArrayList<>()).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>(anagrams.values());
        return result;
    }
}
