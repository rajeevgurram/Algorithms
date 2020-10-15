package DataStructures.LinkedList.Double;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node<T> {
    private T data;
    Node<T> prev, next;
}
