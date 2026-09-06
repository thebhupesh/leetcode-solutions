class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> m = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            
            String sortedStr = String.valueOf(chars);
            List<String> curr = m.getOrDefault(sortedStr, new ArrayList<>());
            
            curr.add(str);
            m.put(sortedStr,curr);
        }

        return new ArrayList<>(m.values());
    }
}