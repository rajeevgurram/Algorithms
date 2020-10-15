package DataStructures.Trie.suffix;

import java.util.List;

public class SuffixTrie {
    private final Node root = new Node();

    public void insert(String word) {
        word = word + "$";
        for(int i = 0; i < word.length(); i ++) {
            insert(word, i);
        }
    }

    private void insert(final String word, int index) {
        Node temp = root;
        for(; index < word.length(); index ++) {
            Node children = temp.getChildrens().get(word.charAt(index));
            if(children == null) {
                children = new Node();
                temp.getChildrens().put(word.charAt(index), children);
            }
            children.getIndex().add(index);
            temp = children;
        }
    }

    public void search(final String word) {
        System.out.println(search(word, 0, root));
    }

    private List<Integer> search(final String word, int index, Node root) {
        if(index == word.length()) return root.getIndex();

        Node node = root.getChildrens().get(word.charAt(index));
        if(node != null) {
            return search(word, ++index, node);
        }

        return null;
    }

    public void print() {
        System.out.println(root.toString());
    }
}
