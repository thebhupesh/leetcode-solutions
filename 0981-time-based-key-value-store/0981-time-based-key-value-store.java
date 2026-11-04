class TimeMap {
    Map<Integer,Map<String,String>> timeMap;
    Map<String,Integer> latestTime;

    public TimeMap() {
        timeMap = new HashMap<>();
        latestTime = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        int time = latestTime.getOrDefault(key,0);
        String val = (time == 0) ? "" : timeMap.get(time).get(key);

        Map<String,String> map = timeMap.getOrDefault(timestamp,new HashMap<>());
        map.put(key,value);
        timeMap.put(timestamp,map);
        latestTime.put(key,timestamp);

        for(time = time+1; time < timestamp; time++) {
            map = timeMap.getOrDefault(time,new HashMap<>());
            map.put(key,val);
            timeMap.put(time,map);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!latestTime.containsKey(key)) return "";
        return (timeMap.containsKey(timestamp) && timeMap.get(timestamp).containsKey(key)) ? timeMap.get(timestamp).get(key) : timeMap.get(latestTime.get(key)).get(key);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */