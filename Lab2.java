/***
 *
 * Lab2 cycles through two arrayLists of heroes, depending on the file that is chosen, and makes them fight until one member faints.
 * There are several key methods used to ensure the fighting works smoothly (isAlive, takeDamage, attack, doBattle) and several that work
 * on the look of the code and are used depending on the command line boolean input (displayHealth), and others (displayMatchup, finalPrint).
 * Using command line inputs and scanners after, the program takes user input to decide which file to pick from and then has assigned pairs
 * of heroes fight until one faints.
 *
 */


// importing key packages that allow file reading and translation to strings in addition to arrayLists
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab2 {

    // creating isAlive method that tells user if hero is still alive (health is over zero)
    // takes in integer health parameter
    public static boolean isAlive(int health)
    {
        // initializing boolean to return
        boolean life;
        // if health is over zero, they are alive - life = true
        if (health > 0)
            life = true;
        // if health is negative, fainted - life = false
        else
            life = false;

        // return statement
        return life;
    }

    // creating takeDamage method to allow for battle, adjusting health depending on strength of hit
    // takes in integer health, integer hurt/damage in parameter
    public static int takeDamage(int health, int hurt)
    {
        // subtracts damage from current health total
        health -= hurt;
        // returns new health total
        return health;
    }

    // creating attack method to establish amount of damage (hurt in above method)
    // takes in String (hero)name, integer light(AttackDamage), integer heavy(AttackDamage), and a boolean to check
    // if full print statements are needed, in parameter
    public static int attack(String name, int light, int heavy, boolean check2)
    {
        // establishing random number that sets up 75% to 25% ratio, is light attack if 75% (1, 2, or 3)
        int interval = (int)(Math.random() * 4) + 1;
        // if 75% (1, 2, or 3)
        if (interval < 4) {
            // if full prints statements are needed (args[0] = true)
            if (check2)
                // print statement that establishes damage being dealt by hero
                System.out.println(name + " performs a light Attack with damage: " + light);
            // returns light attack value
            return light;
        }
        // if 25% (4)
        else {
            // same as above but with heavy attack value
            if (check2)
                System.out.println(name + " performs a heavy Attack with damage: " + heavy);
            return heavy;
        }
    }

    // creating displayMatchup method to clean up main code, simply states the two heroes fighting
    // takes both hero names in parameter
    public static void displayMatchup(String name, String name2)
    {
        // print statement that achieves this
        System.out.println(name + " VS. " + name2);
    }

    // creating displayHealth method to also clean up main code, but in more complex manner
    // takes both hero names, as well as their respective healths in parameter
    public static void displayHealth(String name1, String name2, int health1, int health2)
    {
        // if both heroes are still alive, list their respective healths after attacks or before
        // code/fight has started
        if ((isAlive(health1)) && (isAlive(health2))) {
            System.out.println(name1 + " has " + health1 + " HP left.");
            System.out.println(name2 + " has " + health2 + " HP left.");
        }
        // if this is not true, find out who has fainted (1, 2, or both)
        else {
            // if one has fainted, print statements to state this and two's health left
            if ((health1 < 0) && (health2 > 0)) {
                System.out.println(name1 + " has fainted.");
                System.out.println(name2 + " has " + health2 + " HP left.");
            }
            // if two has fainted, print statements to state this and one's health left
            else if ((health2 < 0) && (health1 > 0)) {
                System.out.println(name2 + " has fainted.");
                System.out.println(name1 + " has " + health1 + " HP left.");
            }
            // if both have fainted, state that both have fainted
            else {
                System.out.println(name1 + " has fainted.");
                System.out.println(name2 + " has fainted.");
            }
        }
    }

    // creating finalPrint method to clean up main code also, does not require the args[0] boolean
    // as it applies to both results, takes in both heroes names and their respective healths
    public static void finalPrint(String name1, String name2, int health1, int health2)
    {
        // similar to above, if two has fainted, one has vanquished the other - print statements to demonstrate this
        if ((health1 > 0) && (health2 < 0)) {
            System.out.println(name1 + " VANQUISHES " + name2 + " with " + health1 + " HP to spare.");
        }
        // similar to above, if one has fainted, two has vanquished the other - print statements to demonstrate this
        else if ((health2 > 0) && (health1 < 0)) {
            System.out.println(name2 + " VANQUISHES " + name1 + " with " + health2 + " HP to spare.");
        }
        else
            // similar to above, if both fainted, neither wins and they are 'evenly matched'
            System.out.println(name1 + " and " + name2 + " are evenly matched.");

        // while these statements run through the same requirements and if statements to check for health,
        // they must be put in a different method as displayHealth is only called if args[0] = true
    }

    // creating most crucial method that uses above methods to execute simulation of the two heroes fighting
    // takes in both team arrayLists in parameter, as well as args[0] to clear for print statements
    public static void doBattle (ArrayList<Hero> firstTeam, ArrayList<Hero> secondTeam, boolean check)
    {
        // initializing nameHolder variables for cleanliness of code, will hold long call to getHeroName for each hero
        String nameHolder1 = "";
        String nameHolder2 = "";
        // same as above for getHeroHealth
        int healthHolder1 = 0;
        int healthHolder2 = 0;
        // same as above for getLightAttackDamage
        int lightHolder1 = 0;
        int lightHolder2 = 0;
        // same as above for getHeavyAttackDamage
        int heavyHolder1 = 0;
        int heavyHolder2 = 0;
        // initializing damageHolder variables to run through the takeDamage function once attack has calculated the hurt
        int damageHolder1 = 0;
        int damageHolder2 = 0;

                // running for loop to run through each hero in the team (both teams same size in either version of boolean)
                for (int j = 0; j < firstTeam.size(); j++) {

                    // setting all holder variables to their respective values for the specific hero using getters
                    nameHolder1 = firstTeam.get(j).getHeroName();
                    nameHolder2 = secondTeam.get(j).getHeroName();
                    healthHolder1 = firstTeam.get(j).getHeroHealth();
                    healthHolder2 = secondTeam.get(j).getHeroHealth();
                    lightHolder1 = firstTeam.get(j).getLightAttackDamage();
                    lightHolder2 = secondTeam.get(j).getLightAttackDamage();
                    heavyHolder1 = firstTeam.get(j).getHeavyAttackDamage();
                    heavyHolder2 = secondTeam.get(j).getHeavyAttackDamage();

                    // using displayMatchup method to print one line (looks cleaner)
                    displayMatchup(nameHolder1, nameHolder2);

                    // checking if args[0] is true
                    if (check) {
                        System.out.println("---------------------------------------------------------");
                        displayHealth(nameHolder1, nameHolder2, healthHolder1, healthHolder2);
                    }

                    // while both heroes are still alive, they must undergo battle using attack and takeDamage
                    while (isAlive(healthHolder1) && isAlive(healthHolder2)) {
                        // if full prints statements are needed (args[0] = true)
                        if (check)
                            // print statement to write a border down
                            System.out.println("---------------------------------------------------------");
                        // establish how much damage each hero will be dealing with their respective variables and args[0] boolean
                        // hero one attack value
                        damageHolder1 = attack(nameHolder1, lightHolder1, heavyHolder1, check);
                        // hero two attack value
                        damageHolder2 = attack(nameHolder2, lightHolder2, heavyHolder2, check);
                        // same logic as above for border
                        if (check)
                            System.out.println("---------------------------------------------------------");
                        // actually giving previously established damage to characters
                        // hero one damage taken
                        healthHolder1 = takeDamage(healthHolder1, damageHolder2);
                        // hero two damage taken
                        healthHolder2 = takeDamage(healthHolder2, damageHolder1);
                        // if full prints statements are needed (args[0] = true)
                        if (check)
                            // utilize displayHealth method to update user on each hero health after every attack
                            displayHealth(nameHolder1, nameHolder2, healthHolder1, healthHolder2);
                    }

                    // same logic as above for border
                    if (check)
                        System.out.println("---------------------------------------------------------");
                    // execute finalPrint statement no matter what the boolean says, establish winner (if there is one) and return loser and remaining health
                    finalPrint(nameHolder1, nameHolder2, healthHolder1, healthHolder2);
                }
    }

    // main code to run
    public static void main(String[] args) throws FileNotFoundException {

        // initializing key variables to ensure command line arguments run smoothly
        // string to hold true or false entry in command line
        String inputPrintFile = "";
        // string to hold name of file user wants to read (herosList/herosListSmall)
        String file = "";
        // string to hold complex directory search to find file to be read
        String fileForScanner = "";
        // integer to hold length that is changed with either file chosen
        int length = 0;
        // command line boolean that is used in above methods to decide on print statements
        boolean printFile = true;

        // confirm that there is actually a value on the command line
        try {
            inputPrintFile = args[0];
        }

        // if no input, demand an input from the user and prompt terminal again
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You must have an input on the command line of 'true' or 'false'.");
        }

        // if true inputted on command line, boolean is true
        if (inputPrintFile.equals("true")) {
            printFile = true;
        }

        // if false inputted on command line, boolean is false
        else if (inputPrintFile.equals("false")) {
            printFile = false;
        }

        // if neither valid inputs are received, tell the user they must input one of the two
        else {
            System.out.println("The print file incorrectly set. Must be 'true' or false'.");
            // exit the code when building or in terminal
            System.exit(1);
        }

        // initialize scanner to read name of file user wants to read once command line arguments are setteld
        Scanner fileReader = new Scanner(System.in);
        // prompts user for desired file name
        System.out.println("Enter file name: ");
        // reads inputted file name from user
        file = fileReader.nextLine();

        // if not one of the two file options, print error messages and request another input
        while (!(file.equals("herosList.csv") || file.equals("herosListSmall.csv"))) {
            // error messages
            System.out.println("Could not open input file. Enter another file name (herosList.csv OR herosListSmall.csv): ");
            // request another input
            file = fileReader.nextLine();
        }

        // if user chooses bigger file
        if (file.equals("herosList.csv")) {
            // set length to 10 (ten heroes on file)
            length = 10;
            // give the complex directory search for this file
            fileForScanner = "/Users/chazpomroy/Desktop/project2-chasepomroy/src/herosList.csv";
        }

        // if user chooses smaller file
        else if (file.equals("herosListSmall.csv")) {
            // set length to 2 (two heroes on file)
            length = 2;
            // give the complex directory search for this file
            fileForScanner = "/Users/chazpomroy/Desktop/project2-chasepomroy/src/herosListSmall.csv";
        }

            // initializing two requested arrayLists of heroes for both teams, length dictated by file chosen
            ArrayList<Hero> team1 = new ArrayList(length/2);
            ArrayList<Hero> team2 = new ArrayList(length/2);

            // putting the main code within try call that confirms one of the two files is actually being read
            try {
                // using fileInputStream to read into file established by previous scanner call
                FileInputStream fileByteStream = new FileInputStream(fileForScanner);
                // initializing scanner to read each specific line of chosen file
                Scanner sc = new Scanner(fileByteStream);
                // making sure there is another line to be read
                while (sc.hasNext()) {
                    // skipping first line that offers descriptors as to what each variable means
                    String skip = sc.nextLine();

                    // for loop to run through the amount of heroes on file
                    for (int i = 0; i < length; i++) {
                        // initializing holder hero to be used for each hero read through the scanner on file
                        Hero holder = new Hero();
                        // using split method to establish a string array that stores all five variables provided, without the commas
                        String[] a = sc.nextLine().split(",");

                        // reading through string array by its length (we know the length is always five though)
                        for (int x = 0; x < a.length; x++) {
                            // if it is the first value, it is the heroName
                            if (x == 0)
                                // set heroName to provided value
                                holder.setHeroName(a[x]);
                            // if it is the second value, it is the heroHealth
                            if (x == 1)
                                // set heroHealth to provided value (convert to integer)
                                holder.setHeroHealth(Integer.parseInt(a[x]));
                            // if it is the third value, it is the lightAttackDamage
                            if (x == 2)
                                // set lightAttackDamage to provided value (convert to integer)
                                holder.setLightAttackDamage(Integer.parseInt(a[x]));
                            // if it is the fourth value, it is the heavyAttackDamage
                            if (x == 3)
                                // set heavyAttackDamage to provided value (convert to integer)
                                holder.setHeavyAttackDamage(Integer.parseInt(a[x]));
                            // if it is the fifth value, it is the team
                            if (x == 4) {
                                // if the team is one, put them in the first team arrayList (convert to integer)
                                if (Integer.parseInt(a[x]) == 1)
                                    team1.add(holder);
                                // if the team is two, put them in the second team arrayList (convert to integer)
                                if (Integer.parseInt(a[x]) == 2)
                                    team2.add(holder);
                            }
                        }
                    }
                }
                // once hero loop finishes and every hero is on their respective teams with their respective variables
                // engage the doBattle method to execute the fighting and print statements
                doBattle(team1, team2, printFile);
            }

            // finish try call by using catch to make sure that the directories find the file properly
            catch (FileNotFoundException e) {
                // if not, state that the directory path failed
                System.out.println("File not found.");
            }
    }
}
