package DataStructures.Trie.suffix;

import java.util.*;

public class Node {
    private Map<Character, Node> childrens;
    List<Integer> indexes;

    public Node() {
        childrens = new HashMap<>();
        indexes = new LinkedList<>();
    }

    public Map<Character, Node> getChildrens() {
        return childrens;
    }

    public void setChildrens(Map<Character, Node> childrens) {
        this.childrens = childrens;
    }

    public List<Integer> getIndex() {
        return indexes;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for(Character c : childrens.keySet()) {
            str.append(c).append("->").append(childrens.get(c));
            //str.append("\n");
        }

        return str.toString();
    }
}
