package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dli = new DoublyLinkedList(1);
        dli.append(2);
        dli.append(3);
        dli.append(4);
        dli.prepend(0);
        dli.remove(2);
//        dli.insert(5,10);
//        System.out.println(dli.get(3).value);
//        dli.set(5,10);
//        dli.removeFirst();
//        dli.removeLast();
        dli.printInfo();
        dli.printDll();

    }
}
