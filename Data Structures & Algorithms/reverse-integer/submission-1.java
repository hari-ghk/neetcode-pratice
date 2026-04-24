class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0 ? true : false;
        x = isNeg? -x : x;
        int digit = 0;
        int result = 0;
        while(x != 0){
            digit = x%10;
            x = x/10;

            if((result > Integer.MAX_VALUE/10) 
                || (result < Integer.MIN_VALUE/10)) 
                return 0;

            result = result * 10 + digit; 
        }
        return isNeg ? -result : result;
    }
}
