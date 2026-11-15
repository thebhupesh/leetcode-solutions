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

    private boolean searchHelper(Node curr, String word, int pos) {
        if(pos == word.length()) return curr.isEnd;

        char c = word.charAt(pos);

        if(c == '.') {
            for(Node n : curr.children) {
                if(n != null && searchHelper(n,word,pos+1)) return true;
            }

            return false;
        }

        curr = curr.children[c-'a'];
        if(curr == null) return false;
        
        return searchHelper(curr,word,pos+1);
    }
    
    public boolean search(String word) {
        return searchHelper(trie,word,0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */