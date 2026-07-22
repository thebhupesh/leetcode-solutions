class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Queue<Integer>> t_char = new HashMap<>();
        Map<Character, Integer> t_freq = new HashMap<>();

        for(char c : t.toCharArray()) {
            t_char.putIfAbsent(c, new LinkedList<>());
            t_freq.put(c, t_freq.getOrDefault(c,0)+1);
        }

        char[] s_char = s.toCharArray();
        int curr_min = -1;
        int count = 0;
        int[] res = new int[]{-1,1000002};

        for(int i=0; i<s_char.length; i++) {
            if(t_char.containsKey(s_char[i])) {
                if(curr_min == -1) curr_min = i;
                
                if(t_freq.get(s_char[i]) > 0) {
                    t_char.get(s_char[i]).offer(i);
                    t_freq.put(s_char[i], t_freq.get(s_char[i])-1);
                    count++;
                } else {
                    int lastPos = t_char.get(s_char[i]).poll();
                    t_char.get(s_char[i]).offer(i);

                    if(lastPos == curr_min) {
                        curr_min = Integer.MAX_VALUE;

                        for(Map.Entry<Character, Queue<Integer>> entry : t_char.entrySet()) {
                            Queue<Integer> q = entry.getValue();
                            if(!q.isEmpty()) curr_min = Math.min(curr_min, q.peek());
                        }
                    }
                }

                if(count == t.length() && res[1]-res[0] > i-curr_min) {
                    res[0] = curr_min;
                    res[1] = i;
                }
            }
        }

        if(res[0] == -1) return "";

        return s.substring(res[0],res[1]+1);
    }
}