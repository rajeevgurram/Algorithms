package DataStructures.Trees.BinaryTree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node<T> {
    private T value;
    private Node<T> left, right;
}
