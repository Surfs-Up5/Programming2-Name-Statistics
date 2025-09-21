import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

    /**
     * The name staistics program will prompt the user to input a list of names delimited by commas. Then the
     * program will display a list of options for the user to pick from. The program will continue to run and
     * allow the user to select multiple options only existng when option 0 is selected
     */

    public class Project1{
    /**
     * Main entry point for the program
     * It then displays a menu of options for processing the names. 
     * The program continues running until the user selects option 0 to exit.
     * @param args command-line arguments
     */
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
            System.out.println("Enter the option you'd like to execute: ");
            choice = scnr.nextInt();
            if(choice == 1){
                orderedList(names);
            }

            if(choice == 2){
                displayFullNames(names);
            }

            if (choice == 3){
                displaySingleNames(names);
            }

            if(choice == 4){
                statistics(names);
            }

            if(choice == 5){
                evenNames(names);
            }

            if(choice == 6){
                oddNames(names);
            }

            if(choice == 7){
                notCapitalized(names);
            }

            if(choice == 8){
                Frequency(names);
            }

            if(choice == 9){
                scnr.nextLine();
                names = enterNames(scnr);
            }

        }//end while
        
        
    }//end method
/**
 * Displays the list of options the user can choose from.
 */
    public static void displayMenu(){
        System.out.println("Options-");
        System.out.println("    1: Display List Ordered");
        System.out.println("    2: Display Full Names");
        System.out.println("    3: Display Single Names");
        System.out.println("    4: Display Name Statistics");
        System.out.println("    5: Display Names with Even Length");
        System.out.println("    6: Display names with odd length");
        System.out.println("    7: Display names NOT Capitalized");
        System.out.println("    8. Display most Frequent Name");
        System.out.println("    9: Enter New List of Names");
        System.out.println("    0: Quit the Program");
    }

    /**
     * Sorts the names entered into alphabetical order and adds them to a new String Array then prints them out.
     * @param names the list of names the user entered
     */
    public static void orderedList(ArrayList<String> names){
    ArrayList<String> sortedNames = new ArrayList<>(names);
    sortedNames.sort(String.CASE_INSENSITIVE_ORDER); // <-- sorts ignoring case
    System.out.println(sortedNames);
    }

    /**
     * Takes the names the user enters and adds only the ones with first and last name to a new string then prints it out.
     * @param names the list of names the user entered
     */
    public static void displayFullNames(ArrayList<String> names) {
    ArrayList<String> fullNames = new ArrayList<>();
    for (String name : names) {
        String[] parts = name.split(" ");
        if (parts.length == 2) {
            fullNames.add(name);
        }
    }
    System.out.println("Option 2 Output:");
    for (String full : fullNames) {
        System.out.println(full);
    }
}//end

    /**
     * Takes the names the user enters and adds only the ones with first name only to a new string then prints it out.
     * @param names the list of names the user entered
     */
    public static void displaySingleNames(ArrayList<String> names) {
    ArrayList<String> singleNames = new ArrayList<>();
    for (String name : names) {
        String[] parts = name.split(" ");
        if (parts.length == 1) {
            singleNames.add(name);
        }
    }

    System.out.println("Option 3 Output:");
    for (String single : singleNames) {
        System.out.println(single);
    }
    }//end method

    /**
     * Takes in the names that the user entered, calculates and outputs: number of names given, total letter count,
     * average length for names, shortest name, longest name, and the population standard deviation of the name lengths.
     * 
     * @param names the list of names the user entered
     */
    public static void statistics(ArrayList<String> names) {
        int nameCount = 0;
        int letterCount = 0;
        double avLength = 0;
        String shortest = "";
        String longest = "";
        double deviation = 0;

        nameCount = names.size();
        for(String name : names){
            String clean = name.replace(" ", "").replace(",", "");
            letterCount += clean.length();
        }
        avLength = (double) letterCount / nameCount;
        avLength = Math.round(avLength * 100.0) / 100.0d;

        shortest = names.get(0);
        int minLength = shortest.replace(" ", "").length();
        for(String name : names){
            int len = name.replace(" ", "").length();
            if (len < minLength){
                minLength = len;
                shortest = name;
            }
        }//end for

        longest = names.get(0);
        int maxLength = longest.replace(" ", "").length();
        for(String name : names){
            int len = name.replace(" ", "").length();
            if (len > maxLength){
                maxLength = len;
                longest = name;
            }
        }//end for

        double sumSqrs = 0.0;
        for(String name : names){
            int len = name.replace(" ", "").length();
            sumSqrs += Math.pow(len - avLength, 2);
        }
        double stdDev = Math.sqrt(sumSqrs / nameCount);
        stdDev = Math.round(stdDev * 100.0) / 100.0d;

        System.out.println("Name count: " + nameCount);
        System.out.println("Letter Count Total: " + letterCount);
        System.out.println("Avg Name Length: " + avLength);
        System.out.println("Shortest Name: " + shortest);
        System.out.println("Longest Name: " + longest);
        System.out.println("Population Standard Deviation: " + stdDev);
    }//end method

    /**
     * takes in names string, calculates the even names, then adds them to a new string and prints the new string.
     * @param names the list of names the user entered
     */
    public static void evenNames(ArrayList<String> names){
        int nameLength = 0;
        ArrayList <String> evenNames = new ArrayList<>();
        for(String name : names){
            String clean = name.replace(" ", "");
            nameLength = clean.length();
            if(nameLength % 2 == 0){
                evenNames.add(name);
            }
        }
        System.out.println(evenNames);
    }//end method

    /**
     * takes in names string, calculates the odd names, then adds them to a new string and prints the new string.
     * @param names the list of names the user entered
     */
    public static void oddNames(ArrayList<String> names){
        int nameLength = 0;
        ArrayList <String> oddNames = new ArrayList<>();
        for(String name : names){
            String clean = name.replace(" ", "");
            nameLength = clean.length();
            if(nameLength % 2 == 1){
                oddNames.add(name);
            }
        }
        System.out.println(oddNames);
    }//end method

/**
 * takes in name string array, calculates the names that are not capitalized, adds them to a new string then prints the string out
 * @param names the list of names the user entered
 */
public static void notCapitalized(ArrayList<String> names){
    ArrayList<String> noCap = new ArrayList<>();
    
    for(String name : names){
        String[] parts = name.split(" ");
        boolean allLower = true;
        
        for(String part : parts){
            if(Character.isUpperCase(part.charAt(0))){
                allLower = false;
                break;
            }
        }
        
        if(allLower){ 
            noCap.add(name);
        }
    }
    System.out.println(noCap);
}

/**
 * calculates the name that was entered the most, and prints it out. If no name was entered the most, prints "no name was entered most"
 * @param names the list of names the user entered
 */
public static void Frequency(ArrayList<String> names){
    HashMap<String, Integer> freq = new HashMap<>();

    for(String name : names){
        String lower = name.toLowerCase();
        freq.put(lower, freq.getOrDefault(lower, 0) + 1);
    }

    String most = "";
    int maxCount = 0;
    for(String key : freq.keySet()){
        int count = freq.get(key);
        if(count > maxCount){
            maxCount = count;
            most = key;
        }
    }

    if(maxCount == 1){
        System.out.println("No most frequent names.");
    } else{
        System.out.println("Most frequent name: " + most);
    }
}

/**
 * allows the user to enter a list of names seperated by commas, then the method seperates the names by the commas, it then
 * trims down white spaces and then adds to final (names) array
 * @param Scanner scnr a Scanner object used to read user input
 * @return a list of trimmed names entered by the user
 */
public static ArrayList<String> enterNames(Scanner scnr) {
    System.out.println("Enter in a list of names deliminated by commas (enter stop to stop): ");
        
        String input = scnr.nextLine();

        ArrayList<String> newNames = new ArrayList<>();

        //splitting up the names
        String[] splitNames = input.split(",");

        //trims down white spaces and adds to final (names) array
        for(String name : splitNames){
            newNames.add(name.trim());
        }
        return newNames ;
}
}//end class