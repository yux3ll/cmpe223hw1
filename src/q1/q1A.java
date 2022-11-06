package q1;
import java.io.*;
import java.util.Scanner;
public class q1A {

    //-----------------------------------------------------
    // Title: Spiral Matrix Reader
    // Author: Yüksel Çağlar Baypınar
    // ID: 43951623744
    // Section: 02
    // Assignment: 1
    // Description: This class takes a file in the form of a matrix as an input
    //  and prints it as a spiral by using linked lists.
    //-----------------------------------------------
    public static void main(String[] args) {
        try {
            Scanner k = new Scanner(System.in);
            String fileName = k.nextLine();
            Scanner input = new Scanner(new File(fileName));
            System.out.println("Input filename: ");
            LinkedList result = matrixSpiral(input);
            if(LinkedList.differentiate0(result))
                LinkedList.printList(result);
        } catch (FileNotFoundException e) {
            System.out.println("File is not found, please adjust your directories accordingly!");
            throw new RuntimeException(e);
        }


    }

    //an iterative approach
    private static LinkedList matrixSpiral(Scanner myFile) {

        LinkedList inputFile = new LinkedList();
        LinkedList spiral = new LinkedList();
        int x = 0, y = 0;

        // This loop helps make it possible to get the data and count rows and columns within one read
        while (myFile.hasNextLine()) {


            Scanner buffer = new Scanner(myFile.nextLine());
            x++;
            while (buffer.hasNextInt()) {
                LinkedList.insert(inputFile, buffer.nextInt());
                if (x == 1) {
                    y++;
                }
            }
        }
        myFile.close();

        double iterations =Math.ceil((double) x/2);

        for(int n=1;n<=iterations;n++){
            //determine starting element (n row n column)
            int startingIndex= (n-1)*y+n;
            int element = LinkedList.getElement(inputFile, startingIndex) ;
            if(element==-1) return spiral;
            LinkedList.insert(spiral, element);

            //at every movement of the cursor, check if given value is the stop value, if so break, if not,add the current entry to the linked list

            //Descend x-(2n-1) times, add each entry to the spiral as we go
            for(int i =1; i<=(x-(2*n-1));i++){
                element=LinkedList.getElement(inputFile, startingIndex+y*i);
                if(element==-1) return spiral;
                LinkedList.insert(spiral, element);
            }

            //go to the right y-(2n-1)(if x-(2n-1)==0)
            for(int i=1; i<=(y-(2*n-1));i++){
                element= LinkedList.getElement(inputFile, startingIndex+(x-(2*n-1))*y+i);
                if(element==-1) return spiral;
                LinkedList.insert(spiral, element);
            }

            //done to avoid overlap
            if(x-(2*n-1)==0){
                return spiral;
            }
            //ascend x-(2n-1) times
            for(int i=1;i<=x-(2*n-1);i++){
                element=LinkedList.getElement(inputFile, startingIndex+(x-(2*n-1))*y+(y-(2*n-1))-y*i);
                if(element==-1) return spiral;
                LinkedList.insert(spiral, element);
            }
            //go to the left y-(2n)
            for(int i=1;i<=(y-2*n);i++){
                element=LinkedList.getElement(inputFile, startingIndex+y-(2*n-1)-i);
                if(element==-1) return spiral;
                LinkedList.insert(spiral, element);
            }

        }
        return spiral;
    }
}
