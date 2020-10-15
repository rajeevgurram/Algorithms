package DataStructures.LinkedList;

import DataStructures.LinkedList.Single.LinkedList;

public class Main {
    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//
//        list.addLast(10);
//        list.addLast(20);
//        list.addLast(30);
//
//        list.print();
//        list.reverse();
//        list.print();
//
//
//
//        LinkedList<Integer> list1 = new LinkedList<>();
//        list1.addLast(1);
//        list1.addLast(5);
//        list1.addLast(10);
//
//        LinkedList<Integer> list2 = new LinkedList<>();
//        list2.addLast(2);
//        list2.addLast(3);
//        list2.addLast(11);
//
//        LinkedList<Integer> merged = list.mergeTwoLists(list1, list2);
//        merged.print();


        DataStructures.LinkedList.Double.LinkedList<Integer> doubleList =
                new DataStructures.LinkedList.Double.LinkedList<>();
        doubleList.addLast(1);
        doubleList.addLast(2);
        doubleList.addLast(3);

        doubleList.print();

        doubleList.reverse();
        doubleList.print();
    }
}
