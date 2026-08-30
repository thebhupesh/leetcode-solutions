class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character,List<Integer>> mp = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            mp.putIfAbsent(t.charAt(i), new ArrayList<>());
            mp.get(t.charAt(i)).add(i);
        }

        int last = -1;

        for(int i=0; i<s.length(); i++) {
            if(mp.containsKey(s.charAt(i))) {
                List<Integer> curr = mp.get(s.charAt(i));
                boolean change = false;
                int min = 0, mid = 0, max = curr.size()-1;
                
                while(min <= max) {
                    mid = min+(max-min)/2;

                    if(mid > 0 && curr.get(mid-1) > last) {
                        max = mid-1;
                    } else if(curr.get(mid) <= last) {
                        min = mid+1;
                    } else {
                        last = curr.get(mid);
                        change = true;
                        System.out.println(s.charAt(i)+":"+last);
                        break;
                    }
                }

                if(!change) return false;

            } else return false;
        }

        return true;
    }
}