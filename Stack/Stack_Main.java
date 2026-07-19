package Stack;

public class Stack_Main {
    public static void main(String[] args) {
        My_Stack ms = new My_Stack(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        ms.push(5);
        ms.pop();
        ms.pop();
        System.out.println(ms.peek());
        ms.printStack();
    }
}
