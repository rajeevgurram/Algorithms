package DataStructures.Trie.suffix;

public class Main {
    public static void main(String[] args) {
        SuffixTrie trie = new SuffixTrie();
        trie.insert("dynamictutorials");
        trie.print();
        trie.search("i");
    }
}
