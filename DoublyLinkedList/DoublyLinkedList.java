package DoublyLinkedList;

public class DoublyLinkedList {

    class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value){
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value){
        Node newNode = new Node(value);

        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printInfo(){
        System.out.println("Head: "+head.value);
        System.out.println("Tail: "+tail.value);
        System.out.println("Length: "+length);
    }

    public void printDll(){
        Node temp = head;
        System.out.print("Values: ");
        while(temp!=null){
            System.out.print(temp.value+" <-> ");
            temp = temp.next;
        }
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void removeLast(){
        if(length == 0){
            System.out.println("List is empty");
        }if(length == 1) {
            head = null;
            tail = null;
            length--;
        }else{
            Node temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
            length--;
        }
    }

    public void prepend(int value){
        if(length == 0){
            append(value);
        }else{
            Node newNode = new Node(value);
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            length++;
        }
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = null;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        if(index < length/2){
            for(int i=0; i<index; i++){
                temp = temp.next;
            }
        }else{
            temp = tail;
            for(int i=length-1; i>index; i--){
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value){
        if(index < 0 || index >= length){
            return false;
        }
        Node temp = get(index);
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length){
            return false;
        }if(index == 0){
            prepend(value);
            return true;
        }if(index == length){
            append(value);
            return true;
        }else{
            Node newNode = new Node(value);
            Node temp = get(index - 1);
            Node temp2 = get(index);
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = temp2;
            temp2.prev = newNode;
            length++;
            return true;
        }
    }

    public Node remove(int index){
        if(index < 0 || index > length){
            System.out.println("Out of Bound");
            return null;
        }if(index == 0){
            removeFirst();
            return null;
        }if(index == length-1){
            removeLast();
            return null;
        }else{
            Node before = get(index - 1);
            Node target = get(index);
            Node after = get(index + 1);
            before.next = target.next;
            target.next = null;
            after.prev = target.prev;
            target.prev = null;
            length--;
            return target;
        }
    }
}
