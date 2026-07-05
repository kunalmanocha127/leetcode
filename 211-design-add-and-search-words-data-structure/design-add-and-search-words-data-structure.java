class TrieNode {
    boolean isLastLetterOfWord;
    TrieNode[] children;
    
    
    public TrieNode() {
        this.isLastLetterOfWord = false;
        this.children = new TrieNode[26];
    }
}


class WordDictionary {
    TrieNode root;

    
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    
    public void addWord(String word) {
        TrieNode n = this.root;
        TrieNode[] children = n.children;
        
        
        for (char letter : word.toCharArray()) {
            int idx = (int) letter - 97;
            
            
            if (children[idx] == null)
                children[idx] = new TrieNode();
            
            
            n = children[idx];
            children = n.children;
        }
        
        
        n.isLastLetterOfWord = true;
    }
    
    
    public boolean searchInTrie(TrieNode n, String word, int startIdx, int endIdx) {
        for (int i = startIdx; i < endIdx; i++) {
            char letter = word.charAt(i);
            
            
            if (letter == '.') {
                boolean wordFound = false;
                
                
                for (TrieNode child : n.children) {
                    if (child != null)
                        wordFound = wordFound || this.searchInTrie(child, word, i + 1, endIdx);
                    
                    
                    if (wordFound)
                        break;
                }
                
                
                return wordFound;
            }
            
            
            int idx = (int) letter - 97;
            
            
            if (n.children[idx] == null)
                return false;


            n = n.children[idx];
        }
        
        
        return n.isLastLetterOfWord;
    }
    
    
    public boolean search(String word) {
        return this.searchInTrie(this.root, word, 0, word.length());
    }
}