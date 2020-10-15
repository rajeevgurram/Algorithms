package DataStructures.Stack;

public class Main {
    public static void main(String[] args) {
        Stacks<Integer> stack = new StackUsingLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.print();
        System.out.println(stack.pop());
        stack.print();
    }
}
