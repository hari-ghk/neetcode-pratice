class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        if(gas.length != cost.length)
            return -1;

        int total = 0;
        int tank = 0;
        int startIdx = 0;
        for(int i = 0; i < gas.length; ++i){
            int diff = gas[i] - cost[i];
            tank += diff; 
            total = total + diff;
            
            if(tank < 0){
                startIdx = i+1;
                tank = 0;
            }
        }
        return total < 0 ? -1 : startIdx;
    }
}
