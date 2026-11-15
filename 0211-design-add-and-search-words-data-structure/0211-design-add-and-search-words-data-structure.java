class WordDictionary {
    Node trie;

    class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            children = new Node[26];
            isEnd = false;
        }
    }

    public WordDictionary() {
        trie = new Node();
    }
    
    public void addWord(String word) {
        Node curr = trie;
        for(char c : word.toCharArray()) {
            if(curr.children[c-'a'] == null) curr.children[c-'a'] = new Node();

            curr = curr.children[c-'a'];
        }

        curr.isEnd = true;
    }

    private boolean wildcardHelper(Node curr, String word, int pos) {
        char c = word.charAt(pos);

        if(c == '.') {
            for(int i=0; i<26; i++) {
                Node temp = curr.children[i];

                if(temp != null) {
                    if(pos+1 == word.length()) {
                        if(temp.isEnd) return true;
                    }
                    else if(wildcardHelper(temp,word,pos+1)) return true;
                }
            }

            return false;
        }

        curr = curr.children[c-'a'];
        
        if(curr == null) return false;
        
        return (pos+1 == word.length()) ? curr.isEnd : wildcardHelper(curr,word,pos+1);
    }
    
    public boolean search(String word) {
        Node curr = trie;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);

            if(c == '.') return wildcardHelper(curr,word,i);
            if(curr.children[c-'a'] == null) return false;

            curr = curr.children[c-'a'];
        }

        return curr.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */