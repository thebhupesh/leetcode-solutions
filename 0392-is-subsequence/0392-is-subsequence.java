class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character,Deque<Integer>> mp = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            mp.putIfAbsent(t.charAt(i), new ArrayDeque<>());
            mp.get(t.charAt(i)).offerLast(i);
        }

        int last = -1;

        for(int i=0; i<s.length(); i++) {
            if(mp.containsKey(s.charAt(i))) {
                Deque<Integer> curr = mp.get(s.charAt(i));
                boolean change = false;
                while(!curr.isEmpty()) {
                    int idx = curr.pollFirst();
                    if(idx > last) {
                        last = idx;
                        change = true;
                        break;
                    }
                }

                if(!change) return false;

            } else return false;
        }

        return true;
    }
}