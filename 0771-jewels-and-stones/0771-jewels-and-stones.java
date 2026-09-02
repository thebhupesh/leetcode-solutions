class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();
        int count = 0;

        for(char jewel : jewels.toCharArray()) jewelsSet.add(jewel);
        for(char stone : stones.toCharArray()) if(jewelsSet.contains(stone)) count++;

        return count;
    }
}