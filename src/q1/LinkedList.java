package q1;

public class LinkedList {
    //-----------------------------------------------------
    // Title: Linked List Implementation
    // Author: Yüksel Çağlar Baypınar
    // ID: 43951623744
    // Section: 02
    // Assignment: 1
    // Description: This class is used to implement Linked lists in
    // a conventional manner except the addition of one new variable
    //-----------------------------------------------
    Node Head= new Node();

    private static class Node {
        int data;
        Node Left, Right;

        //used to differentiate between cases where the list has a single element that is 0, or is empty
        boolean initialized;

        Node(){
            initialized =false;
        }
        Node(int data) {
            this.data = data;
            Right = null;
            initialized =true;

        }
    }
    public static void editElement(LinkedList list, int n, int newValue){
        Node set = list.Head;

        for(int i=0; i<n-1;i++){
            set=set.Right;
        }
        set.data=newValue;
    }
    public static int getElement(LinkedList list, int n){

        Node get = list.Head;

        for(int i=0; i<n-1; i++){
            get = get.Right;
        }
        return get.data;
    }
    public static void insert(LinkedList list, int data) {

        Node newNode = new Node(data);

        if (!list.Head.initialized) {
            list.Head = newNode;
        } else {
            Node last = list.Head;
            while (last.Right != null) {
                last = last.Right;

            }

            last.Right = newNode;
            newNode.Left=last;
        }
    }
    public static int length(LinkedList list){
        Node temp = list.Head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.Right;
        }
        return count;
    }
    public static boolean includes(LinkedList list, int checkNum){
        Node check = list.Head;
        if(check.data== checkNum){
            return true;
        }
        while(check.Right != null){
            check = check.Right;
            if(check.data == checkNum){
                return true;
            }
        }
        return false;
    }
    public static boolean differentiate0(LinkedList list){
        return list.Head.initialized;
    }
    public static void printList(LinkedList list){

        Node currNode = list.Head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.Right;
        }
    }
}

