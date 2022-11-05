package q1;
import java.util.LinkedList;

public class q1A {

    //input: file including a matrix
    //result: given matrix read spirally
    //implementation requirement: linked lists

    public static  void main(String[] args){

    }

    private LinkedList<Integer> spiralMatrix(){

        //create a linked list

        //determine the numbers of rows(x) and columns(y)(read the file from top to bottom and left to right until null value is reached


        // for(n starting from 1, less than or equal to x/2(ceiling),n++):
            //determine first element (n row n column)
            //at every movement of the cursor, check if given value is the stop value, if so break, if not,add the current entry to the linked list
            //Descend x-(2n-1) times
            //go to the right y-(2n-1)(if x-(2n-1)==0, then break here to avoid overlap)
            //ascending x-(2n-1) times
            //go to the left y-(2n)
        // return the list



    }

}
