import java.util.ArrayList;
import java.util.Scanner;



public class ListMaker {
    private static final ArrayList<String> myArrList = new ArrayList<>();
    private static final Scanner in = new Scanner(System.in);


    public static void main(String[] args) {

        boolean done = false;

        do {
            System.out.println("\nCommand Options:");
            System.out.println("A – Add an item to the list");
            System.out.println("D – Delete an item from the list");
            System.out.println("I – Insert an item into the list");
            System.out.println("P – Print the list");
            System.out.println("Q – Quit the program \n");

            display();

            String userChoice = SafeInput.getRegExString(in, "\nEnter a command (A, D, I, P, Q): ", "[AaDdIiPpQq]");
            String command = userChoice.toUpperCase(); //convert user input to uppercase

            switch (command) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    display();
                    break;
                case "Q":
                    if (quitConfirm()) {
                        done = true;
                    }
                    break;
            }


        } while (!done);
        System.out.println("\n -*- Program Terminated. -*-");
    }


    private static void display() {

        for(int i = 0; i < myArrList.size(); i++) {
            System.out.println((i + 1) + ". " + myArrList.get(i));
        }
    }
    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to be added to the list:");
        myArrList.add(item);
        System.out.println("-*- " + item + " was added. -*-");
    }

    private static void deleteItem() {

            //check that list is not empty
        int listSize = myArrList.size();
        if (listSize == 0) {
            System.out.println("\n -*- Sorry, the list is empty. There is nothing to delete. -*-");
            return;
        }
                //get input to delete item
        int itemNumRemove = SafeInput.getRangedInt(in, "Enter the number of the item to be removed from the list", 1, listSize);

            //convert item to index compatible num
        int indexToRemove = itemNumRemove -1;

            //remove item

        myArrList.remove(indexToRemove);
        System.out.println("\n -*- Item number " + itemNumRemove + " has been successfully deleted. -*-");



    }

    private static void insertItem() {
        int listSize = myArrList.size();

        int maxRange = listSize + 1;

        int insertNum = SafeInput.getRangedInt(in, "Enter the item number to be inserted in", 1, maxRange);
        int indexInsertNum = insertNum -1;

        String replacedItem = SafeInput.getNonZeroLenString(in, "Enter what you wish to insert into item number " + insertNum);

        //inserting
        myArrList.add(indexInsertNum, replacedItem);
    }

    private static boolean quitConfirm() {
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit? ");
    }



}
