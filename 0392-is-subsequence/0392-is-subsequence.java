class Solution {
    public boolean isSubsequence(String s, String t) {
        int s_ptr = 0;
        
        for(char ch : t.toCharArray()) {
            if(s_ptr == s.length()) break;
            if(ch == s.charAt(s_ptr)) s_ptr++;
        }

        return s_ptr == s.length();
    }
}

// Follow-up Approach
// class Solution {
//     private Map<Character,List<Integer>> mp;

//     private void preprocess(String t) {
//         mp = new HashMap<>();

//         for(int i=0; i<t.length(); i++) {
//             mp.putIfAbsent(t.charAt(i), new ArrayList<>());
//             mp.get(t.charAt(i)).add(i);
//         }
//     }

//     private int searchIndex(List<Integer> list, int last) {
//         int min = 0, mid = 0, max = list.size()-1;
                
//         while(min <= max) {
//             mid = min+(max-min)/2;
//             if(mid > 0 && list.get(mid-1) > last) {
//                 max = mid-1;
//             } else if(list.get(mid) <= last) {
//                 min = mid+1;
//             } else return list.get(mid);
//         }

//         return -1;
//     }

//     private boolean process(String s) {
//         int last = -1;
//         for(int i=0; i<s.length(); i++) {
//             if(mp.containsKey(s.charAt(i))) {
//                 last = searchIndex(mp.get(s.charAt(i)), last);
//                 if(last == -1) return false;
//             } else return false;
//         }

//         return true;
//     }

//     public boolean isSubsequence(String s, String t) {
//         preprocess(t);
//         return process(s);
//     }
// }