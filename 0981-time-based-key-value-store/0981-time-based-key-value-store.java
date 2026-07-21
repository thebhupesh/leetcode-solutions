class TimeMap {
    HashMap<String,TreeMap> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> values = timeMap.getOrDefault(key, new TreeMap<>());
        values.put(timestamp,value);
        timeMap.put(key,values);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> values = timeMap.getOrDefault(key, new TreeMap<>());
        Integer time = values.floorKey(timestamp);

        if(time == null) return "";

        return values.get(time);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */