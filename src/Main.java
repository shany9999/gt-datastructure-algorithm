public class Main {
    public static void Main(String[] args) {
        System.out.println("hello, data structure and algorithm");
    }



//    public static void main(String[] args) {
//        //III.Sorting;divide and conquer
//        int[] arrayTwo = new int[5];
//        arrayTwo[0] = -50;
//        arrayTwo[1] = 500;
//        arrayTwo[2] = 15;
//        arrayTwo[3] = -210;
//        arrayTwo[4] = 0;
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(arrayTwo[i]);
//        }
//        System.out.println("==========");
//
//        III.Sorting.lsdRadixSort(arrayTwo);
//        for (int i = 0; i < 5; i++) {
//            System.out.println(arrayTwo[i]);
//        }
//    }




//    public static void main(String[] args) {
//        Integer[] arrayOne = new Integer[10];
//        for (int i = 9; i >= 0; i--) {
//            arrayOne[i] = -i+9 ;
//        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(arrayOne[i]);
//        }
//
//
//    }






//    public static void main(String[] args) {
//        II.ExternalChainingHashMap<Integer, Integer> exMap = new II.ExternalChainingHashMap<>();
//        /* YuanYuan */
//        for (int i = 0; i < 9; i++) {
//            exMap.put(new Integer(13*i), new Integer(i));
//        }
//
//        System.out.println(exMap.size());
//        System.out.println(exMap.getTable().length);
//
//        exMap.remove(new Integer(13));
//        System.out.println(exMap.size());
//        System.out.println(exMap.getTable().length);
//    }






//    public static void main(String[] args) {
//        II.MinHeap newheap = new II.MinHeap();
////        for (int i = 1; i <= 10; i++) {
////            newheap.add(i);
////        }
//
//        newheap.add(0);
//        newheap.add(14);
//        newheap.add(7);
//        newheap.add(28);
//        newheap.add(21);
//        newheap.add(56);
//        newheap.add(49);
////        newheap.add(42);
////        newheap.add(35);
//
//        //System.out.println(newheap.getBackingArray()[10]);
//        for (int i = 0; i <= newheap.size(); i++) {
//            System.out.println(newheap.getBackingArray()[i]);
//        }
//        System.out.println("===================");
//        newheap.remove();
//        for (int i = 0; i <= newheap.size(); i++) {
//            System.out.println(newheap.getBackingArray()[i]);
//        }
//    }





//    public static void main(String[] args) {
//        I.SinglyLinkedList lst = new I.SinglyLinkedList();
//        System.out.println(lst.size());
//        lst.addToFront(1);
//        lst.addToFront(0);
//        lst.addToBack(2);
//        I.SinglyLinkedListNode cur = lst.getHead();
//        System.out.println(lst.size());
//        for (int i = 0; i < lst.size(); i++) {
//            System.out.println("list: "+ cur.getData());
//            cur = cur.getNext();
//        }
//    }


}