public class Main {

    public static void main(String[] args) {
//**************************ArrayList*****************************************
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Aram");
        myArrayList.add("Hayk");
        myArrayList.add("Grigor");
        for (String e : myArrayList) {
            System.out.println(e);
        }
//**************************SinglyLinkedList***********************************
        SinglyLinkedList<Integer> mySinglyLinkedList = new SinglyLinkedList<>();

        mySinglyLinkedList.add(2);
        mySinglyLinkedList.add(7);
        mySinglyLinkedList.add(10);

        mySinglyLinkedList.printElem();
        System.out.println();
        mySinglyLinkedList.find(7);
        mySinglyLinkedList.deleteElemAt(2);
        mySinglyLinkedList.insertFirst(20);
        mySinglyLinkedList.insertElemAt(70, 2);
        mySinglyLinkedList.printElem();
        System.out.println();
        for (int it : mySinglyLinkedList) {
            System.out.print(it + " ");
        }
    }
}