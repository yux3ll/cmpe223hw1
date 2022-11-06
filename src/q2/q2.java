package q2;

import q1.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class q2 {

    //-----------------------------------------------------
    // Title: Linked List Implementation
    // Author: Yüksel Çağlar Baypınar
    // ID: 43951623744
    // Section: 02
    // Assignment: 1
    // Description: This class prints a list of numbers that tell the
    // number of consecutive entries that are higher than or equal to the current entry in given order.
    //-----------------------------------------------

    public static void main(String[] args) {
        try {
            Scanner k = new Scanner(System.in);
            String fileName = k.nextLine();
            k.close();
            Scanner input = new Scanner(new File(fileName));
            System.out.println("Input filename: ");
            LinkedList.printList(spanCheck(input));
        }
        catch (FileNotFoundException e) {
            System.out.println("File is not found, please adjust your directories accordingly!");
            throw new RuntimeException(e);
        }
    }


    private static LinkedList spanCheck(Scanner input){
        int entryAmount=0;
        LinkedList values = new LinkedList();
        LinkedList results = new LinkedList();
        Stack prices = new Stack();

        while(input.hasNextInt()){ //Take the input into a linked-list
            LinkedList.insert(values, input.nextInt());
            entryAmount++;
        }

        for(int i=0;i<entryAmount;i++){ //Create stack from said linked list
            prices.push(LinkedList.getElement(values ,entryAmount-i));
        }

        LinkedList.insert(results,1); //The first element will always be 1 and doesn't need processing
        prices.pop();


        for(int i=2; i<=entryAmount;i++){ //process each element of the stack
            int x= prices.pop();
            int tempMax=0;
            LinkedList.insert(results, 0);


            for(int j=1; j<=i;j++){  //compare the values again the previous values, keep the current maximum value in a temporary variable
                if(x<=LinkedList.getElement(values,j)){
                    tempMax++;
                    if(tempMax>LinkedList.getElement(results,i)){// check after each increment if the temporary value is greater than currently recorded one
                        LinkedList.editElement(results,i,tempMax);
                    }
                }else{ tempMax=0;}
            }
        }

  return results;
    }

}