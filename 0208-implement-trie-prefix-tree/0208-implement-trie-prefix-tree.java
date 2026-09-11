class Trie {
    class Node {
        Node[] nodes;
        boolean end;

        Node() {
            this.nodes = new Node[26];
            this.end = false;
        }
    }

    Node[] trie;

    public Trie() {
        trie = new Node[26];
    }
    
    public void insert(String word) {
        Node[] curr = trie;
        int len = word.length();

        for(int i=0; i<len; i++) {
            int idx = word.charAt(i)-'a';

            if(curr[idx] == null) curr[idx] = new Node();
            if(i+1 == len) curr[idx].end = true;
            curr = curr[idx].nodes;
        }
    }
    
    public boolean search(String word) {
        Node[] curr = trie;
        int len = word.length();

        for(int i=0; i<len; i++) {
            int idx = word.charAt(i)-'a';

            if(curr[idx] == null || (i+1 == len && !curr[idx].end)) return false;
            curr = curr[idx].nodes;
        }

        return true;
    }
    
    public boolean startsWith(String prefix) {
        Node[] curr = trie;
        
        for(char c : prefix.toCharArray()) {            
            if(curr[c-'a'] == null) return false;
            curr = curr[c-'a'].nodes;
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */