package part.a;

import java.util.Scanner;

/**
 * <p>
 * Class ContactList, represents a contact list sheet which contains a database
 * of Person's that have both names and phone numbers.
 * </p>
 * 
 * @author Armin T.
 * @version v1.0 Jan 13, 2016
 */
public class ContactList {

    /** database Person, represents a database of people it numbers. */
    private Person[] database;
    /** input Scanner, is a scanner for taking in user input. */
    private Scanner input;
    /** databaseSize represents the size of the database array. */
    private int databaseSize;

    /**
     * <p>
     * Constructor, ContactList instantiates the database and the Scanner for
     * use in the run() method.
     * </p>
     */
    public ContactList() {
        database = new Person[0];
        input = new Scanner(System.in);
    }

    /**
     * <p>
     * Method, add() is responsible for adding a Person to the database. Creates
     * a new array temporarily of the correct new size, then copies it over to
     * the database[] and addes the person.
     * </p>
     * 
     * @param person
     *            is the Person obj that is passed to be added
     */
    public void add(final Person person) {
        if (person != null && database.length < 1) {
            Person[] temp = new Person[database.length + 1];
            database = temp;
            database[databaseSize] = person;
            databaseSize++;

        } else if (person != null) {
            Person[] temp = new Person[database.length + 1];
            System.arraycopy(database, 0, temp, 0, databaseSize);
            database = temp;
            database[databaseSize] = person;
            databaseSize++;
        }
    }

    /**
     * <p>
     * Method, search(), takes in a Person's name as a string and searches the
     * database array for that Person, and returns the index location of that
     * Person.
     * </p>
     * 
     * @param name
     *            , the Person's first and last names.
     * @return the index of the location of a Person's name in the array.
     */
    public int search(final String name) {
        int personIndex = -1;

        for (int i = 0; i < database.length; i++) {

            if (name.replaceAll("\\s+", "").equalsIgnoreCase(
                    database[i].getFirstName() 
                  + database[i].getLastName())) {

                personIndex = i;
            }
        }

        return personIndex;
    }

    /**
     * <p>
     * Method, displayAll(), displays the entire contents of database[] array,
     * in a table format using printf.
     * </p>
     */
    public void displayAll() {
        System.out.printf("%-20s %-15s\n", "Name", "Phone Number");
        System.out.println("---------------------------------");
        for (Person p : database) {
            System.out.printf("%-20s %-15s\n", p.formatName(),
                    p.formatPhoneNum());
        }

    }

    /**
     * <p>
     * Method, remove, takes in a Person's name as a String, calls search()
     * method to find the indexed location of that person and the removes that
     * person from the data base. by copying and shrinking the database array.
     * </p>
     * 
     * @param name
     *            a Person's name to remove from DB
     * @return a boolean value to indicate whether action was performed
     */
    public boolean remove(final String name) {
        int pos = search(name);
        if (pos >= 0) {
            Person[] temp = new Person[database.length - 1];
            System.arraycopy(database, 0, temp, 0, pos);
            System.arraycopy(database, pos + 1, temp, pos,
                    database.length - pos - 1);
            database = temp;
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Method displayMenu() displays the user options menu, a user can then
     * enter a number to access the function, although this handled in another
     * function.
     * </p>
     */
    public void displayMenu() {
        System.out.println("\n\n\n1) Add");
        System.out.println("2) Delete");
        System.out.println("3) Search");
        System.out.println("4) Display All");
        System.out.println("5) Exit\n");
    }

    /**
     * <p>
     * Method, getChoice() handles the user input handling for menu choice. User
     * enters a number 1 - 5, and getChoice(), takes that and passes it to the
     * choice evaluation method, run().
     * </p>
     * 
     * @return an int that represents a choice from 1 - 5 inclusive.
     */
    public int getChoice() {
        int choice = 4;// default
        boolean done = false;
        while (!done) {
            System.out.print("choice? \n");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (choice > 0 && choice <= 5) {
                done = true;
            } else {
                System.out.println(
                        "\nYour choice is incorrect, please try again");
            }
        }
        return choice;
    }

    /**
     * <p>
     * Method, addPerson() adds a Person to the database Person[] array. It
     * first identifies if the array is empty if so, it uses one if block to
     * initially populate the array. From there on, it will create a new array,
     * 1 size larger than the existing array and copy that over and add the
     * Person to the new larger array.
     * </p>
     */
    public void addPerson() {
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String phone = "";

        System.out.println("now in addperson()");

        try {
            System.out.println("Enter person's first name please:");
            firstName = input.next();
            System.out.println("Enter middle name please,"
                             + " or null for none:");
            middleName = input.next();
            if (middleName.equalsIgnoreCase("null")) {
                middleName = "";
            }

            System.out.println("Enter person's last name please:");
            lastName = input.next();

            System.out.print("\nEnter the persons phone number(10): ");
            phone = input.next();
            System.out.println("");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (middleName.length() > 0) {
            add(new Person(phone, firstName, middleName, lastName));
        } else {
            add(new Person(phone, firstName, lastName));
        }
    }

    /**
     * <p>
     * Method, deletePerson(), Takes in user input, the first and last names of
     * the person you wish to delete, it then calls the remove method which
     * access the search method, finds the person and the remove method then
     * deletes it. It will also deliver a message upon success of failure.
     * </p>
     */
    public void deletePerson() {
        String firstName = "";
        String lastName = "";

        try {
            System.out.println("Enter the person's first name: ");
            firstName = input.next();
            System.out.println("Enter the person's last name:");
            lastName = input.next();
            firstName = firstName + " " + lastName;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // never seen this kind of call before....interesting
        // calling a not on the method still means it's a method call
        if (!remove(firstName)) {
            System.out.println("Could not delete " + firstName);
        } else {
            System.out.println(firstName + " was deleted successfully");
        }
    }

    /**
     * <p>
     * Method, findPerson() locates a person. It takes user input of the first
     * name and last names. Then searches the database for that person.
     * </p>
     */
    public void findPerson() {
        String name = "";

        try {
            System.out.println("Enter the person's first name: ");
            name = input.next();
            System.out.println("Enter the person's last name: ");
            name = name + " " + input.next();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int pos = search(name);
        System.out.println(search(name));
        if (pos >= 0) {
            System.out.printf("%-20s %-15s\n", "Name", "Phone Number");
            System.out.println("---------------------------------");
            System.out.printf("%-20s %-15s\n", database[pos].formatName(),
                    database[pos].formatPhoneNum());
        } else {
            System.out.println("No such person");
        }
    }

    /**
     * <p>
     * Method run(), serves as a program initialization/control method. When a
     * choice is selected and passed, this program makes the correct call to a
     * method that serves that purpose.
     * </p>
     */
    public void run() {
        int choice = 0;
        do {
            displayMenu();
            choice = getChoice();
            switch (choice) {
              case 1:
                  addPerson();
                  break;
              case 2:
                  deletePerson();
                  break;
              case 3:
                  findPerson();
                  break;
              case 4:
                  displayAll();
              default:
                // should not get here
            }

        } while (choice != 5);
    }

    /**
     * <p>
     * Method Main, serves as an entry point to the program. a ContactList is
     * initialized and the run method is called right away.
     * </p>
     * 
     * @param args
     *            not used. CLI arguments
     */
    public static void main(String[] args) {
        new ContactList().run();
    }
}
