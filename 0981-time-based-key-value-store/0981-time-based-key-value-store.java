class TimeMap {
    Map<String,List<Pair<Integer,String>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key,k -> new ArrayList<>()).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> values = timeMap.get(key);
        if(values == null) return "";

        int left = 0;
        int right = values.size()-1;
        String res = "";

        while(left <= right) {
            int mid = left + (right-left)/2;
            Pair<Integer,String> curr = values.get(mid);

            if(curr.getKey() <= timestamp) {
                res = curr.getValue();
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */