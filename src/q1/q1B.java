
package q1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class q1B {

    //-----------------------------------------------------
    // Title: q1B
    // Author: Yüksel Çağlar Baypınar
    // ID: 43951623744
    // Section: 02
    // Assignment: 1
    // Description: This class is used to find out if in a given matrix
    // the indexes of two given lists are neighbors of each other
    //-----------------------------------------------

    public static void main(String[] args) {
        try {
            Scanner k = new Scanner(System.in);

            System.out.println("Input filename: ");
            String matrixFileName = k.nextLine();
            matrixFileName=matrixFileName.replace("\"",""); // our inputs are in quotes, which we need to get rid of

            System.out.println("Input filename: ");
            String list1FileName =k.nextLine();
            list1FileName=list1FileName.replace("\"","");

            System.out.println("Input filename: ");
            String list2FileName =k.nextLine();
            list2FileName=list2FileName.replace("\"","");

            Scanner inputMatrix = new Scanner(new File(matrixFileName));
            Scanner inputList1 = new Scanner(new File(list1FileName));
            Scanner inputList2 = new Scanner(new File(list2FileName));
            inputList1.useDelimiter("\\s+|,|-"); //this is done so that the files aren't just a single line
            inputList2.useDelimiter("\\s+|,|-");

            System.out.println(neighborhood(inputMatrix,inputList1,inputList2));

        } catch (FileNotFoundException e) {
            System.out.println("File is not found, please adjust your directories accordingly!");
            throw new RuntimeException(e);
        }

    }

    private static boolean neighborhood(Scanner matrixTxt,Scanner list1Txt,Scanner list2Txt){ //converts 2d array into 1d and algebraically assign indexes for easier processing

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        int x=0, y=0;


        while (matrixTxt.hasNextLine()) { //we needn't copy over the contents of the matrix, just it's dimensions will suffice
            Scanner buffer = new Scanner(matrixTxt.nextLine());
            x++;
            while (buffer.hasNextInt()) {
                buffer.nextInt();
                if (x == 1) {
                    y++;
                }
            }
        }
        matrixTxt.close();


        while(list1Txt.hasNext()){ //conversion of 2d indexes to 1d
            int a=list1Txt.nextInt();
            int b=list1Txt.nextInt();

            LinkedList.insert(list1, a*y+b+1);
        }
        list1Txt.close();
        while(list2Txt.hasNext()){
            int a=list2Txt.nextInt();
            int b=list2Txt.nextInt();

            LinkedList.insert(list2, a*y+b+1);
        }
        list2Txt.close();

        for(int i=1; i<=LinkedList.length(list2); i++){ //checks for neighbors in all 4 directions, excluding the ones within the same list

            boolean temp1=true,temp2=true,temp3=true,temp4=true;
            int k=LinkedList.getElement(list2,i);
            if(!LinkedList.includes(list2,k+y)){
                temp1 = LinkedList.includes(list1,k+y);
            }
            if(!LinkedList.includes(list2,k-y)){
                temp2 = LinkedList.includes(list1,k-y);
            }
            if(!LinkedList.includes(list2,k+1)){
                temp3 = LinkedList.includes(list1,k+1);
            }
            if(!LinkedList.includes(list2,k-1)){
                temp4 = LinkedList.includes(list1,k-1);
            }
            if(temp1 && temp2 && temp3 && temp4){
                return true;
            }

        }
        return false;


    }


}