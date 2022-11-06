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

            System.out.println("Input filename: ");
            String fileName = k.nextLine();

            k.close();

            Scanner input = new Scanner(new File(fileName));

            LinkedList result = matrixSpiral(input);

            if(LinkedList.differentiate0(result))
                LinkedList.printList(result);

        } catch (FileNotFoundException e) {
            System.out.println("File is not found, please adjust your directories accordingly!");
            throw new RuntimeException(e);
        }


    }


    private static LinkedList matrixSpiral(Scanner myFile) {   //an iterative approach

        LinkedList inputFile = new LinkedList();
        LinkedList spiral = new LinkedList();
        int x = 0, y = 0;


        while (myFile.hasNextLine()) {  // This loop helps make it possible to get the data and count rows and columns within one read


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

        for(int n=1;n<=iterations;n++){ //at every movement of the cursor, check if given value is the stop value, if so break, if not,add the current entry to the linked list

            int startingIndex= (n-1)*y+n;  //determine starting element (n row n column)
            int element = LinkedList.getElement(inputFile, startingIndex) ;
            if(element==-1) return spiral; // -1 is a sign to stop the reading
            LinkedList.insert(spiral, element);

            for(int i =1; i<=(x-(2*n-1));i++){ //Descend x-(2n-1) times, add each entry to the spiral as we go
                element=LinkedList.getElement(inputFile, startingIndex+y*i);
                if(element==-1) return spiral;
                LinkedList.insert(spiral, element);
            }

            for(int i=1; i<=(y-(2*n-1));i++){ //go to the right y-(2n-1)
                element= LinkedList.getElement(inputFile, startingIndex+(x-(2*n-1))*y+i);
                if(element==-1) return spiral;
                LinkedList.insert(spiral, element);
            }


            if(x-(2*n-1)==0){  //done to avoid overlap in certain cases
                return spiral;
            }

            for(int i=1;i<=x-(2*n-1);i++){  //ascend x-(2n-1) times
                element=LinkedList.getElement(inputFile, startingIndex+(x-(2*n-1))*y+(y-(2*n-1))-y*i);
                if(element==-1) return spiral;
                LinkedList.insert(spiral, element);
            }

            for(int i=1;i<=(y-2*n);i++){  //go to the left y-(2n)
                element=LinkedList.getElement(inputFile, startingIndex+y-(2*n-1)-i);
                if(element==-1) return spiral;
                LinkedList.insert(spiral, element);
            }

        }
        return spiral;
    }
}
