class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        
        double total = 1.0;
        for(int i = 1; i <=Math.abs(n); ++i){
            if(n < 0)
                total *= 1/x;  
            else 
                total *= x;  
        }
        return total;
    }
}
