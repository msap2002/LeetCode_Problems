class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //one pass algorithm
        int n = gas.length;
        int start = 0,gasInTank = 0;
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += gas[i] - cost[i];
            gasInTank += gas[i] - cost[i];
            if(gasInTank < 0){
                start = i + 1;
                gasInTank = 0;
            }
        }
        return (sum >= 0) ? start : -1;
    }
}