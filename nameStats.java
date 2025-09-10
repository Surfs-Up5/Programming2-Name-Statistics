import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class nameStats{

    public static void main(String[] args) {

        //declaring
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        int choice = -1;

        System.out.println("Enter in a list of names deliminated by commas (enter stop to stop): ");
        String input = scnr.nextLine();

        //splitting up the names
        String[] splitNames = input.split(",");

        //trims down white spaces and adds to final (names) array
        for(String name : splitNames){
            names.add(name.trim());
        }

        System.out.println("You entered: " + names);
        
        while(choice != 0){
            displayMenu();
            choice = scnr.nextInt();
            if(choice == 1){
                orderedList(names);
            }

        }
        
        
    }//end method

    public static void displayMenu(){
        System.out.println("Options-");
        System.out.println("    1: Display List Ordered");
        System.out.println("    2: Display Full Names");
        System.out.println("    3: Display Single Names");
        System.out.println("    4: Display Name Statistics");
        System.out.println("    5: Display Names with Even Length");
        System.out.println("    6: Display names with odd length");
        System.out.println("    8: Display names NOT Capitalized");
        System.out.println("    9: Enter New List of Names");
        System.out.println("    0: Quit the Program");
    }

    //Alphabetical Sorting
    public static void orderedList(ArrayList<String> names){
        ArrayList<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames);
        System.out.println(sortedNames);
    }



}//end class