package DataStructures.Trees.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(10);
        tree.add(5);
        tree.add(20);
        tree.add(2);
        tree.add(6);
        tree.add(15);
        tree.add(30);
        tree.add(1);
        tree.add(3);
        tree.add(8);
        tree.add(13);
        tree.add(16);
        tree.add(25);
        tree.add(35);
        tree.add(11);
        tree.add(14);
        tree.add(17);
        tree.add(23);
        tree.add(26);
        tree.add(31);
        tree.add(40);



        BinaryTree tree1 = new BinaryTree();
        tree1.add(10);
        tree1.add(5);
        tree1.add(20);
        tree1.add(2);
        tree1.add(6);
        tree1.add(15);
        tree1.add(30);
        tree1.add(1);
        tree1.add(3);
        tree1.add(8);
        tree1.add(13);
        tree1.add(16);
        tree1.add(25);
        tree1.add(35);
        tree1.add(11);
        tree1.add(14);
        tree1.add(17);
        tree1.add(23);
        tree1.add(26);
        tree1.add(31);
        tree1.add(40);

        System.out.println(tree.isEqual(tree1.getRoot()));

        System.out.println(tree.height());

        System.out.println(tree.commonAncestor(11, 14));

        tree.print();
        tree.deleteNode(11);tree.print();
        tree.deleteNode(30);tree.print();
        tree.deleteNode(10);

        tree.print();

        BinaryTree tree2 = new BinaryTree();
        tree2.add(-2);
        tree2.add(-1);
        tree2.add(-3);
        tree2.add(-13);
        System.out.println("");
        tree2.print();
        tree2.getMaximumPathSum();
    }
}
