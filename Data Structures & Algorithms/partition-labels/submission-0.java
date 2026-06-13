class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int end = 0;
        int currSize = 0;
        Map<Character, Integer> countMap = new HashMap<>();

        for(int i = 0; i < s.length(); ++i){
            countMap.put(s.charAt(i), i);
        }

        for(int i = 0; i < s.length(); ++i){
            char currChar = s.charAt(i);
            end = Math.max(countMap.get(currChar), end);
            currSize++;
            if(i == end){
                result.add(currSize);
                currSize = 0;
            }
        }
        return result;
    }
}
