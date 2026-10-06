class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', new ArrayList<>(List.of('a','b','c')));
        map.put('3', new ArrayList<>(List.of('d','e','f')));
        map.put('4', new ArrayList<>(List.of('g','h','i')));
        map.put('5', new ArrayList<>(List.of('j','k','l')));
        map.put('6', new ArrayList<>(List.of('m','n','o')));
        map.put('7', new ArrayList<>(List.of('p','q','r','s')));
        map.put('8', new ArrayList<>(List.of('t','u','v')));
        map.put('9', new ArrayList<>(List.of('w','x','y','z')));

        List<String> res = new ArrayList<>(List.of(""));

        for(char c : digits.toCharArray()) {
            List<Character> chars = map.get(c);
            List<String> tempRes = new ArrayList<>();

            for(String str : res) {
                for(Character ch : chars) {
                    tempRes.add(str+ch);
                }
            }

            res = tempRes;
        }

        return res;
    }
}