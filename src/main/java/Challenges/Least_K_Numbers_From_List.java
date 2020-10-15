/**
 * Given two sorted lists (or arrays) and a number k,
 * create an algorithm to fetch the least k numbers of the
 * two lists.
 */

package Challenges;

class Least_K_Numbers_From_List {
     public static void main(String[] args) {
         int[] list1 = {1, 5, 8, 12, 16, 20, 25, 29, 50};
         int[] list2 = {0, 2, 4, 6, 22, 25, 29, 52, 60, 78, 100};
         least_k_numbers(list1, list2, 2);
     }

     private static int[] least_k_numbers(int[] list1, int[] list2, int k) {
         int[] leastNumbers = new int[k];
         // index for list1 and list2
         int l1Index = 0, l2Index = 0;
         for(int i = 0; i < k; i ++) {
             leastNumbers[i] = list1[l1Index] > list2[l2Index] ?
                     list2[l2Index++] : list1[l1Index++];
             System.out.println(leastNumbers[i]);
         }
         return leastNumbers;
     }
}
