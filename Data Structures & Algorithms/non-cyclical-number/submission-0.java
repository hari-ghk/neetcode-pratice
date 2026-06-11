class Solution {
    public boolean isHappy(int n) {

        if(n == 1)
            return true;

        Set<Integer> sums = new HashSet<>();
        int sum = 0;
        int temp = n;
        while(!sums.contains(temp)){
            sums.add(temp);

            while(temp > 0){
                int digit = temp % 10;
                sum += (digit * digit);
                temp /= 10;
            }

            if(sum == 1)
                return true;
            temp = sum;
            sum = 0;
        }
        return false;
    }
}
