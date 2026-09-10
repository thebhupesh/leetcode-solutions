class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        List<List<Integer>> temps = new ArrayList<>();

        int min = temperatures[0];
        
        for(int i=0; i<71; i++) temps.add(new ArrayList<>());

        for(int i=0; i<temperatures.length; i++) {
            for(int j=temperatures[i]-1; j>=min; j--) {
                List<Integer> temp = temps.get(j-30);
                for(int k=temp.size()-1; k>=0; k--) {
                    if(res[temp.get(k)] == 0) {
                        res[temp.get(k)] = i-temp.get(k);
                        temp.remove(k);
                    }
                }
            }
            temps.get(temperatures[i]-30).add(i);
            min = Math.min(temperatures[i],min);
        }

        return res;
    }
}