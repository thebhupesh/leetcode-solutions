class Node {
    Node[] next;
    boolean end;

    Node() {
        next = new Node[26];
        end = false;
    }
}

class Trie {
    Node data;

    public Trie() {
        data = new Node();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node curr = data;

        for (char ch : chars) {
            if (curr.next[ch - 'a'] == null) {
                curr.next[ch - 'a'] = new Node();
            }
            curr = curr.next[ch - 'a'];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node curr = data;

        for (char ch : chars) {
            if (curr.next[ch - 'a'] == null) {
                return false;
            }
            curr = curr.next[ch - 'a'];
        }

        return curr.end;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node curr = data;

        for (char ch : chars) {
            if (curr.next[ch - 'a'] == null) {
                return false;
            }
            curr = curr.next[ch - 'a'];
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