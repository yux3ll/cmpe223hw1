package q2;

public class Stack {

    Node top;
    public Stack(){
        this.top=null;
    }
    private static class Node {

        int data;
        Node link;

    }


    public void push(int x){

        Node temp = new Node();
        temp.data=x;
        temp.link=this.top;
        this.top=temp;
    }
    public boolean stackEmpty(){
        return top==null;
    }

    public int pop(){
        if(stackEmpty()){
            System.out.println("Stack is empty");
            return 0;
        }
        else{
            int x= top.data;
            top=top.link;
            return x;
        }
    }

}
