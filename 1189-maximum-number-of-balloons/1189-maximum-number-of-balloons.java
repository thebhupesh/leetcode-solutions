class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];

        for(char c : text.toCharArray()) chars[c-'a']++;

        int res = Integer.MAX_VALUE;

        for(char c : "balon".toCharArray()) {
            if(c == 'l' || c == 'o') res = Math.min(res,chars[c-'a']/2);
            else res = Math.min(res,chars[c-'a']);
        }

        return res;
    }
}


// With maps and sets

// class Solution {
//     public int maxNumberOfBalloons(String text) {
//         Set<Character> charSet =  new HashSet<>();
//         Map<Character,Integer> charMap = new HashMap<>();

//         for(char c : "balon".toCharArray()) {
//             charMap.put(c,0);
//             charSet.add(c);
//         }
        
//         for(char c : text.toCharArray()) if(charSet.contains(c)) charMap.merge(c,1,Integer::sum);

//         Iterator<Map.Entry<Character,Integer>> itr = charMap.entrySet().iterator();
//         int res = Integer.MAX_VALUE;
        
//         while(itr.hasNext()) {
//             Map.Entry<Character,Integer> curr = itr.next();
//             if(curr.getKey() == 'l' || curr.getKey() == 'o') res = Math.min(res,curr.getValue()/2);
//             else res = Math.min(res,curr.getValue());
//         }

//         return res;
//     }
// }