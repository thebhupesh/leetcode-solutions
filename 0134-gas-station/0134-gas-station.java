class Solution {
    private int travel(int start, int[] gas, int[] cost, int currGas, int idx, Map<List<Integer>,Integer> dp) {
        idx = idx%gas.length;
        
        if(dp.containsKey(List.of(idx,currGas))) return dp.get(List.of(idx,currGas));
        if(idx == start) return idx;

        currGas += gas[idx]-cost[idx];
        if(currGas < 0) {
            dp.put(List.of(idx,currGas), idx);
        } else {
            dp.put(List.of(idx,currGas), travel(start,gas,cost,currGas,idx+1,dp));
        }

        return dp.get(List.of(idx,currGas));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        for(int i=0; i<len; i++) {
            Map<List<Integer>,Integer> dp = new HashMap<>();
            if(gas[i] >= cost[i]) {
                int val = travel(i,gas,cost,gas[i]-cost[i],i+1,dp);

                if(val == i) return i;
                else if(val > i) i=val;
                else break;
            }
        }

        return -1;
    }
}