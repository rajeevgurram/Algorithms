package DataStructures.Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node<Integer> root;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(Integer value) {
        Node<Integer> newNode = new Node<>(value, null, null);
        addRecursively(newNode, root);
        size++;
    }

    private void addRecursively(final Node<Integer> newNode, 
                                final Node<Integer> temp) {
        if(temp == null) {
            root = newNode;
        } else {
            if(newNode.getValue() > temp.getValue() || 
                newNode.getValue() == temp.getValue()) {
                if(temp.getRight() != null) {
                    addRecursively(newNode, temp.getRight());
                } else {
                    temp.setRight(newNode);
                }
            } else if(newNode.getValue() < temp.getValue()) {
                if(temp.getLeft() != null) {
                    addRecursively(newNode, temp.getLeft());
                } else {
                    temp.setLeft(newNode);
                }
            }
        }
    }

    public void print() {
        //preOrder(root);
        inOrder(root);
        //postOrder(root);
        System.out.println("");
    }

    private void preOrder(Node<Integer> temp) {
        if(temp == null) {
            return;
        } else {
            System.out.print(temp.getValue() + " ");
            preOrder(temp.getLeft());
            preOrder(temp.getRight());
        }
    }

    private void inOrder(Node<Integer> temp) {
        if(temp == null) {
            return;
        } else {
            inOrder(temp.getLeft());
            System.out.print(temp.getValue() + " ");
            inOrder(temp.getRight());
        }
    }

    private void postOrder(Node<Integer> temp) {
        if(temp == null) {
            return;
        } else {
            postOrder(temp.getLeft());
            postOrder(temp.getRight());
            System.out.print(temp.getValue() + " ");
        }
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public boolean isEqual(Node<Integer> temp) {
        return isEqual(root, temp);
    }

    private boolean isEqual(Node<Integer> head, Node<Integer> temp) {
        if (temp != null && head != null) {
            if (head.getValue() != temp.getValue()) {
                return false;
            }

            return isEqual(head.getLeft(), temp.getLeft()) &&
                    isEqual(head.getRight(), temp.getRight());
        }
        return true;
    }

    public int height() {
        //return heightRecursive(root);
        return heightIterative(root);
    }

    private int heightRecursive(Node<Integer> node) {
        if(node == null) {
            return 0;
        }
        System.out.println(node.getValue());
        return 1 + Math.max(heightRecursive(node.getLeft()), heightRecursive(node.getRight()));
    }

    private int heightIterative(Node<Integer> node) {
        int result = 0;
        if(node == null) {
            return result;
        }

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(node);

        while (true) {

            int count = queue.size();
            if(count == 0) {
                return result;
            }
            result++;

            while (count > 0) {
                Node<Integer> data = queue.poll();

                if(data.getLeft() != null) {
                    queue.add(data.getLeft());
                }
                if(data.getRight() != null) {
                    queue.add(data.getRight());
                }

                count --;
            }
        }
    }

    public Integer commonAncestor(int a, int b) {
        return commonAncestor(root, a, b);
    }

    private Integer commonAncestor(Node<Integer> node, int a, int b) {
        if(node == null) return null;

        if(node.getValue() > a && node.getValue() < b) {
            return node.getValue();
        } else {
            if(node.getValue() > a && node.getValue() > b) {
                return commonAncestor(node.getLeft(), a, b);
            } else {
                return commonAncestor(node.getRight(), a, b);
            }
        }
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    private Node<Integer> getParentNode(Node<Integer> node, int value) {
        if(node == null) {
            return null;
        }

        if(node.getLeft().getValue() == value || node.getRight().getValue() == value) {
            return node;
        } else {
            if(node.getValue() > value) {
                return getParentNode(node.getLeft(), value);
            } else if(node.getValue() < value) {
                return getParentNode(node.getRight(), value);
            }
        }

        return null;
    }

    private void deleteNode(final Node<Integer> node, int value) {
        Node<Integer> parentNode = getParentNode(node, value);
        Node<Integer> nodeTobeDeleted = null;

        if(parentNode == null) {
            if(root.getValue() == value) {
                parentNode = nodeTobeDeleted = root;
            } else {
                return;
            }
        }

        if(parentNode.getLeft().getValue() == value) {
            nodeTobeDeleted = parentNode.getLeft();
        } else if(parentNode.getRight().getValue() == value) {
            nodeTobeDeleted = parentNode.getRight();
        }

        // case 1: no children nodes to the node.
        if(nodeTobeDeleted.getLeft() == null && nodeTobeDeleted.getRight() == null) {
            if(parentNode.getLeft().getValue() == value) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        } else {
            // case 2: with children.
            Node<Integer> leftMostNode = getLeftMostHighestNode(node, nodeTobeDeleted.getLeft());
            if(parentNode != nodeTobeDeleted) {
                if (parentNode.getLeft().getValue() == value) {
                    parentNode.setLeft(leftMostNode);
                } else {
                    parentNode.setRight(leftMostNode);
                }
            } else {
                root = leftMostNode;
            }
            // case 3: delete root node.
            leftMostNode.setLeft(nodeTobeDeleted.getLeft());
            leftMostNode.setRight(nodeTobeDeleted.getRight());
        }
    }

    private Node<Integer> getLeftMostHighestNode(Node<Integer> parent, Node<Integer> node) {
        if(node.getRight() != null) {
            return getLeftMostHighestNode(node, node.getRight());
        } else {
            parent.setRight(null);
        }

        return node;
    }

    private int max_path_sum = Integer.MIN_VALUE;
    public void getMaximumPathSum() {
        getMaximimPathSum(root);
        System.out.println("Max Path: " + max_path_sum);
    }

    private int getMaximimPathSum(final Node<Integer> temp) {
        if(temp == null) {
            return 0;
        }

        int left = Math.max(0, getMaximimPathSum(temp.getLeft()));
        int right = Math.max(0, getMaximimPathSum(temp.getRight()));

        max_path_sum = Math.max(max_path_sum, left + right + temp.getValue());
        return Math.max(left, right) + temp.getValue();
    }
}
