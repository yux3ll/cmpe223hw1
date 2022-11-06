package q2;

import q1.LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class q2 {

    //input: file that includes a list of numbers
    //a list of numbers that tell the number of consecutive entries that are higher than or equal to the current entry in given order
    // implementation requirement: stack/queue

    public static void main(String[] args) {
        try {
            Scanner k = new Scanner(System.in);
            String fileName = k.nextLine();
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
        // take input into a linked-list
        //create stack from said linked list
       while(input.hasNextInt()){
            LinkedList.insert(values, input.nextInt());
            entryAmount++;
            prices.push(LinkedList.getElement(values ,entryAmount));
        }
        LinkedList.insert(results,1);
        prices.pop();
       for(int i=1; i<=entryAmount-1;i++){
        int x= prices.pop();
        int tempMax=0;
        LinkedList.insert(results, 0);
            for(int j=1; j<=i;j++){
                if(x<=LinkedList.getElement(values,j)){
                    tempMax++;
                    if(tempMax>LinkedList.getElement(results,i)){
                        LinkedList.editElement(results,i,tempMax);
                    }
                }else{ tempMax=0;}
            }
       }

        //process one b one from stack and pop,
        //pop, check in link list ltr, stop determined by iteration number,
        //store results in a new linked list
        //return last list
return results;
    }

}