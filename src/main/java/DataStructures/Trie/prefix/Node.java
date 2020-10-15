package DataStructures.Trie.prefix;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private final Map<Character, Node> childMap;
    private boolean isCompleteWord;

    public Node() {
        childMap = new HashMap<>();
        isCompleteWord = false;
    }

    public Map<Character, Node> getChildMap() {
        return childMap;
    }

    public boolean isCompleteWord() {
        return isCompleteWord;
    }

    public void setCompleteWord(boolean completeWord) {
        isCompleteWord = completeWord;
    }
}
