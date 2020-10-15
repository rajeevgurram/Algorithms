package DataStructures.Trie.prefix;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private final Node root;
    int count = 0;

    public Trie() {
        root = new Node();
    }

    public void add(final String data) {
        Node temp = root;
        for(final Character character : data.toCharArray()) {
            Node node = temp.getChildMap().get(character);
            if(node == null) {
                node = new Node();
                temp.getChildMap().put(character, node);
            }
            temp = node;
        }
        temp.setCompleteWord(true);
        count++;
    }

    public List<String> search(final String prefix) {
        Node temp = root;
        List<String> result = new ArrayList<>();

        for(final Character character : prefix.toCharArray()) {
            Node node = temp.getChildMap().get(character);

            if(node == null) {
                break;
            } else {
                temp = node;
            }
        }

        createWords(prefix, temp, result);
        return result;
    }

    private void createWords(final String prefix, final Node node, List<String> result) {
        if(node == null) {
            return;
        }

        if(node.isCompleteWord()) {
            result.add(prefix);
        }

        for(Character character : node.getChildMap().keySet()) {
            final StringBuilder builder = new StringBuilder(prefix);
            Node _node = node.getChildMap().get(character);
            builder.append(character);
            createWords(builder.toString(), _node, result);
        }
    }
}
