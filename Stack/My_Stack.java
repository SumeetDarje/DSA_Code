package Stack;

public class My_Stack {
    private Node top;
    private int size;

    class Node{
        Node next;
        int value;

        public Node(int value){
            this.value = value;
        }
    }

    public My_Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        size = 1;
    }

    public void push(int value){
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void pop(){
        if(top == null){
            System.out.println("Stack is Empty");
            return;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        size--;
    }

    public int peek(){
        if(top == null){
            return -1;
        }
        return top.value;
    }

    public void printStack(){
        Node temp = top;
        System.out.println("Top: "+top.value);
        System.out.println("Size: "+size);
        System.out.print("Stack: ");
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }

    }


}
