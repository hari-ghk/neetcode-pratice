class Solution {
    public boolean checkValidString(String s) {
        
        Deque<Integer> braces = new ArrayDeque<>();
        Deque<Integer> stars = new ArrayDeque<>();

        for(int i = 0; i < s.length(); ++i){
            Character currChar = s.charAt(i);
            if(currChar == ')'){
                if(braces.size() == 0 && stars.size() == 0)
                    return false;
                else if(braces.size() > 0 && braces.peek() < i)
                    braces.pop();
                else if(stars.size() > 0 && stars.peek() < i)
                    stars.pop();
            } else if(currChar == '('){
                    braces.push(i);
            } else if(currChar == '*'){
                    stars.push(i);
            } else {
                return false;
            }            
        }

        if(braces.size() == 0 && stars.size() > 0)
            return true;
        else if(braces.size() > 0 && stars.size() == 0)
            return false;
        else {
            while(braces.size() > 0 && stars.size() > 0){
                if(braces.peek() > stars.peek())
                    return false;
                else {
                    braces.pop();
                    stars.pop();
                }
            }
        }

        if(braces.size() > 0)   
            return false;
        
        return true;
    }
}
